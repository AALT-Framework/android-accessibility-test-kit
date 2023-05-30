package br.usp.icmc.ppgccmc.accessibilitytestkit;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;

import android.os.Build;
import android.view.View;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import br.usp.icmc.ppgccmc.accessibility_tests.runners.AccessibilityTestRunner;
import br.usp.icmc.ppgccmc.accessibility_tests.mars.TestAdequateContrastRatio;
import br.usp.icmc.ppgccmc.accessibility_tests.mars.TestFocusBasedNavigationSuport;
import br.usp.icmc.ppgccmc.accessibility_tests.mars.TestInteractionElementSpacing;
import br.usp.icmc.ppgccmc.accessibility_tests.mars.TestMustFormControlHaveLabel;
import br.usp.icmc.ppgccmc.accessibility_tests.mars.TestMustHaveAlternativeText;
import br.usp.icmc.ppgccmc.accessibility_tests.mars.TestTouchTargetSize;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.P)
public class MainActivityTest {
    private MainActivity activity;
    private View rootView;
    private AccessibilityTestRunner runner;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();

        // Get the root node of the view hierarchy
        rootView = activity.getWindow().getDecorView().getRootView();
        runner = new AccessibilityTestRunner(collector);
    }

    @Test
    public void testMultipleAssertions() {
        String s = "hello";
        collector.checkThat("Length is incorrect", s.length(), equalTo(6));
        collector.checkThat("String does not start with 'h'", s, startsWith("e"));
        collector.checkThat("String does not end with 'o'", s, endsWith("l"));
    }

    @Test
    public void testAccessibility() {
        runner.runAllAccessibilityTests(rootView);
        //runner.runAccessibilityTest(rootView, new TestMustHaveAlternativeText());
        /*runner.runAccessibilityTest(rootView, new TestAdequateContrastRatio());
        runner.runAccessibilityTest(rootView, new TestFocusBasedNavigationSuport());
        runner.runAccessibilityTest(rootView, new TestMustFormControlHaveLabel());
        runner.runAccessibilityTest(rootView, new TestTouchTargetSize());
        runner.runAccessibilityTest(rootView, new TestInteractionElementSpacing());*/
    }

    @Test
    public void mustSupportFocusBasedNavigationSuport(){
        runner.runAccessibilityTest(rootView, new TestFocusBasedNavigationSuport());
    }

    @Test
    public void mustHaveAlternativeText(){
        runner.runAccessibilityTest(rootView, new TestMustHaveAlternativeText());
    }

    @Test
    public void mustTouchTargetHasMinimumSize(){
        runner.runAccessibilityTest(rootView, new TestTouchTargetSize());
    }

    @Test
    public void mustInteractionElementHaveEnoughSpacing(){
        runner.runAccessibilityTest(rootView, new TestInteractionElementSpacing());
    }

    @Test
    public void mustHaveAdequateContrastRatio(){
        runner.runAccessibilityTest(rootView, new TestAdequateContrastRatio());
    }

    @Test
    public void mustFormControlHaveLabel(){
        runner.runAccessibilityTest(rootView, new TestMustFormControlHaveLabel());
    }
}
