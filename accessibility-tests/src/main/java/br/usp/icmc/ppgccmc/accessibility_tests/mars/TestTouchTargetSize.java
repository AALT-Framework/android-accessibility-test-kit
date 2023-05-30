package br.usp.icmc.ppgccmc.accessibility_tests.mars;

import static org.junit.Assert.assertTrue;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.junit.rules.ErrorCollector;

import br.usp.icmc.ppgccmc.accessibility_tests.IAccessibilityTestViewHierarchy;
import br.usp.icmc.ppgccmc.accessibility_tests.helpers.TestOutputHelper;

public class TestTouchTargetSize implements IAccessibilityTestViewHierarchy {
    @Override
    public Class[] getApplicableWidgets() {
        return new Class[] { Button.class, ImageButton.class };
    }

    @Override
    public void runTest(View view, ErrorCollector collector) {
        assertTrue("Touch target size less then 48dp in : " + TestOutputHelper.getViewId(view), view.getHeight() < 48 || view.getWidth() < 48);
        /*if(view.getHeight() < 48 || view.getWidth() < 48){
            collector.addError(new Throwable("Touch target size less then 48dp in : " + view));
        }*/
    }
}
