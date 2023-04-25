package br.usp.icmc.ppgccmc.accessibility_tests;

import android.view.View;

import org.junit.rules.ErrorCollector;

/**
 * Interface for accessibility tests that perform your own way to run through the view hierarchy
 */
public interface IAccessibilityTestSelfContained {
    /**
     * Run test for current view. Each test implements your own checks.
     * Any error is added to the collector
     * @param view current view
     * @param collector error collector
     */
    void runTest(View view, ErrorCollector collector);
}
