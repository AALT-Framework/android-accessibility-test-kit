package br.usp.icmc.ppgccmc.accessibility_tests.mars;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import org.junit.rules.ErrorCollector;

import br.usp.icmc.ppgccmc.accessibility_tests.IAccessibilityTestViewHierarchy;

public class TestMustHaveAlternativeText implements IAccessibilityTestViewHierarchy {

    @Override
    public Class[] getApplicableWidgets() {
        return new Class[]{Button.class, ImageButton.class, ImageView.class};
    }

    @Override
    public void runTest(View view, ErrorCollector collector) {
        collector.checkThat("Content description missing for view: " + view, view.getContentDescription(), is(notNullValue()));
    }
}
