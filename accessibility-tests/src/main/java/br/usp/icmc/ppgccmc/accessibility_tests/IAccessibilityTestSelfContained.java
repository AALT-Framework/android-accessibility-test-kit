package br.usp.icmc.ppgccmc.accessibility_tests;

import android.view.View;

import org.junit.rules.ErrorCollector;

public interface IAccessibilityTestSelfContained {
    void runTest(View view, ErrorCollector collector);
}
