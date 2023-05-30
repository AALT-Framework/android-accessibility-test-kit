package br.usp.icmc.ppgccmc.accessibility_tests.runners;

import android.view.View;
import android.view.ViewGroup;

import org.junit.Rule;
import org.junit.rules.ErrorCollector;

import br.usp.icmc.ppgccmc.accessibility_tests.IAccessibilityTestSelfContained;
import br.usp.icmc.ppgccmc.accessibility_tests.IAccessibilityTestViewHierarchy;
import br.usp.icmc.ppgccmc.accessibility_tests.mars.TestAdequateContrastRatio;
import br.usp.icmc.ppgccmc.accessibility_tests.mars.TestInteractionElementSpacing;
import br.usp.icmc.ppgccmc.accessibility_tests.mars.TestMustFormControlHaveLabel;
import br.usp.icmc.ppgccmc.accessibility_tests.mars.TestMustHaveAlternativeText;
import br.usp.icmc.ppgccmc.accessibility_tests.mars.TestTouchTargetSize;

/**
 * Test Runner for accessibility tests.
 * It give some helpers to run tests whole all view hierarchy
 */
public class AccessibilityTestRunner {
    @Rule
    public ErrorCollector collector;

    public AccessibilityTestRunner(ErrorCollector errorCollector){
        this.collector = errorCollector;
    }

    /**
     * Performs the test's self-contained logic
     * @param view to be tested
     * @param acTest self-contained test to be executed
     */
    public void runAccessibilityTest(View view, IAccessibilityTestSelfContained acTest){
        acTest.runTest(view, collector);
    }

    /**
     * Transverse the whole view hierarchy starting from the given view.
     * Run test if view is in list of applicable widgets.
     * Then, call recursively to child views
     * @param view root view
     * @param acTest test to be executed for whole view hierarchy
     */
    public void runAccessibilityTest(View view, IAccessibilityTestViewHierarchy acTest){
        // If view belongs to the test targets, execute the test
        if(isViewInList(view, acTest.getApplicableWidgets())) {
            try {
                acTest.runTest(view, collector);
            } catch (Exception e){
                collector.addError(e);
            }
        }

        // If it's a viewgroup, perform a recursive call to child views
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                runAccessibilityTest(viewGroup.getChildAt(i), acTest);
            }
        }
    }

    /**
     * Run all default tests from kit
     * @param rootView root view
     */
    public void runAllAccessibilityTests(View rootView){
        runAccessibilityTest(rootView, new TestAdequateContrastRatio());
        runAccessibilityTest(rootView, new TestMustFormControlHaveLabel());
        runAccessibilityTest(rootView, new TestMustHaveAlternativeText());
        runAccessibilityTest(rootView, new TestTouchTargetSize());
        runAccessibilityTest(rootView, new TestInteractionElementSpacing());
    }

    /**
     * Check if given view is in applicable widgets list for given test
     * @param view current view
     * @param classes applicable widgets list
     * @return true if view is applicable for the test, false otherwise
     */
    private boolean isViewInList(View view, Class[] classes) {
        for (Class c : classes) {
            if(c.isInstance(view))
                return true;
        }

        return false;
    }
}
