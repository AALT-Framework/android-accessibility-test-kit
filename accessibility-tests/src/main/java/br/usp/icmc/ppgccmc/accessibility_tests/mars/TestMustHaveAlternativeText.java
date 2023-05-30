package br.usp.icmc.ppgccmc.accessibility_tests.mars;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import org.junit.rules.ErrorCollector;

import br.usp.icmc.ppgccmc.accessibility_tests.IAccessibilityTestViewHierarchy;
import br.usp.icmc.ppgccmc.accessibility_tests.helpers.TestOutputHelper;

public class TestMustHaveAlternativeText implements IAccessibilityTestViewHierarchy {

    @Override
    public Class[] getApplicableWidgets() {
        return new Class[]{Button.class, ImageButton.class, ImageView.class};
    }

    @Override
    public void runTest(View view, ErrorCollector collector) {
        assertThat("Content description missing for view: " + TestOutputHelper.getViewId(view), view.getContentDescription(), is(notNullValue()));
    }
}
