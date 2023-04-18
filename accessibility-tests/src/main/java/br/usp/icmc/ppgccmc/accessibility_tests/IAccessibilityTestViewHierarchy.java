package br.usp.icmc.ppgccmc.accessibility_tests;

import android.view.View;

import org.junit.rules.ErrorCollector;

public interface IAccessibilityTestViewHierarchy {
    Class[] getApplicableWidgets();
    void runTest(View view, ErrorCollector collector);
}
