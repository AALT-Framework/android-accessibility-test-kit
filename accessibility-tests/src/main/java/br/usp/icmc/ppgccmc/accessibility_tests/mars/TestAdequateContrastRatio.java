package br.usp.icmc.ppgccmc.accessibility_tests.mars;

import static org.hamcrest.Matchers.greaterThan;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.graphics.ColorUtils;

import org.junit.rules.ErrorCollector;

import br.usp.icmc.ppgccmc.accessibility_tests.IAccessibilityTestViewHierarchy;
import br.usp.icmc.ppgccmc.accessibility_tests.helpers.TestOutputHelper;


public class TestAdequateContrastRatio implements IAccessibilityTestViewHierarchy {
    public static final double MIN_CONSTRAST_RATIO = 4.5;

    @Override
    public Class[] getApplicableWidgets() {
        return new Class[]{TextView.class,Button.class,ImageButton.class,ImageView.class};
    }

    @Override
    public void runTest(View view, ErrorCollector collector) {
        if (view.getBackground() instanceof ColorDrawable) {

            try {
                ColorDrawable cd = (ColorDrawable) view.getBackground();
                int backgroundColor = cd.getColor();
                int textColor;

                if (view instanceof TextView) {
                    textColor = ((TextView) view).getCurrentTextColor();
                } else if(view instanceof EditText) {
                    textColor = ((EditText) view).getCurrentTextColor();
                }
                else if(view instanceof Button) {
                    textColor = ((Button) view).getCurrentTextColor();
                }
                else{
                    textColor = view.getSolidColor();
                }

                final double ratio = ColorUtils.calculateContrast(backgroundColor, textColor);

                // Assert that the contrast ratio is greater than 4.5:1, which is the minimum requirement for WCAG 2.0 AA level compliance
                //assertThat("Taxa de contraste inadequada para " + view.getTag(),  ratio, greaterThan(MIN_CONSTRAST_RATIO));
                collector.checkThat("Taxa de contraste inadequada para " + TestOutputHelper.getViewId(view),  ratio, greaterThan(MIN_CONSTRAST_RATIO));

            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }

    }
}
