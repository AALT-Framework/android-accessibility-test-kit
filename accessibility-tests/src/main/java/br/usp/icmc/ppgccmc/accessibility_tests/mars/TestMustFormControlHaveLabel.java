package br.usp.icmc.ppgccmc.accessibility_tests.mars;

import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

import org.junit.rules.ErrorCollector;

import br.usp.icmc.ppgccmc.accessibility_tests.IAccessibilityTestViewHierarchy;

public class TestMustFormControlHaveLabel implements IAccessibilityTestViewHierarchy {
    @Override
    public Class[] getApplicableWidgets() {
        return new Class[] { EditText.class, CheckBox.class, RadioButton.class, Switch.class };
    }

    @Override
    public void runTest(View view, ErrorCollector collector) {
        boolean hasLabelFor = false;
        ViewGroup viewGroup = (ViewGroup) view.getParent();

        if(viewGroup != null){
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                if(child.getLabelFor() == view.getId()){
                    hasLabelFor = true;
                }
            }
        }

        collector.checkThat("Input " + view + " has no label associated",  hasLabelFor, is(true));
    }
}
