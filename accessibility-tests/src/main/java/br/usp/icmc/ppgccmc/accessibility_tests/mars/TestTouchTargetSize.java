package br.usp.icmc.ppgccmc.accessibility_tests.mars;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.junit.rules.ErrorCollector;

import br.usp.icmc.ppgccmc.accessibility_tests.IAccessibilityTestViewHierarchy;

public class TestTouchTargetSize implements IAccessibilityTestViewHierarchy {
    @Override
    public Class[] getApplicableWidgets() {
        return new Class[] { Button.class, ImageButton.class };
    }

    @Override
    public void runTest(View view, ErrorCollector collector) {
        int height = view.getHeight();
        int width = view.getWidth();

        // get padding left + right
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();

        // get padding top + bottom
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();

        // get height and width plus padding
        int heightWithPadding = height + paddingTop + paddingBottom;
        int widthWithPadding = width + paddingLeft + paddingRight;

        //assertTrue("Touch target size less then 48dp in : " + TestOutputHelper.getViewId(view), view.getHeight() < 48 || view.getWidth() < 48);
        if(heightWithPadding < 48 || widthWithPadding < 48){
            collector.addError(new Throwable("Touch target size less then 48dp in : " + view));
        }
    }
}



