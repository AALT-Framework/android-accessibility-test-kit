package br.usp.icmc.ppgccmc.accessibility_tests;

import android.view.View;

import org.junit.rules.ErrorCollector;

/**
 * Interface for accessibility tests that allow the runner to transverse the view hierarchy
 * and perform tests on each view.
 */
public interface IAccessibilityTestViewHierarchy {
    /**
     * Get all applicable widgets for given test
     * @return an array of applicable widget classes
     */
    Class[] getApplicableWidgets();

    /**
     * Run test for current view. Each test implements your own checks.
     * Any error is added to the collector
     * @param view current view
     * @param collector error collector
     */
    void runTest(View view, ErrorCollector collector);
}
