package br.usp.icmc.ppgccmc.accessibility_tests.runners;

import android.view.View;
import android.view.ViewGroup;

import org.junit.Rule;
import org.junit.rules.ErrorCollector;

import br.usp.icmc.ppgccmc.accessibility_tests.IAccessibilityTestSelfContained;
import br.usp.icmc.ppgccmc.accessibility_tests.IAccessibilityTestViewHierarchy;

public class AccessibilityTestRunner {
    @Rule
    public ErrorCollector collector;

    public AccessibilityTestRunner(ErrorCollector errorCollector){
        this.collector = errorCollector;
    }

    public void runAccessibilityTest(View view, IAccessibilityTestSelfContained acTest){
        acTest.runTest(view, collector);
    }

    public void runAccessibilityTest(View view, IAccessibilityTestViewHierarchy acTest){
        // Se view pertence aos alvos do teste, executa o teste
        if(isViewInList(view, acTest.getApplicableWidgets())) {
            acTest.runTest(view, collector);
        }

        // Se for um viewgroup, realiza chamada recursiva para views filhas
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                runAccessibilityTest(viewGroup.getChildAt(i), acTest);
            }
        }
    }

    private boolean isViewInList(View view, Class[] classes) {
        for (Class c : classes) {
            if(c.isInstance(view))
                return true;
        }

        return false;
    }
}
