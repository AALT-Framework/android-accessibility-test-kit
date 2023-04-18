package br.usp.icmc.ppgccmc.accessibility_tests.mars;

import static org.hamcrest.CoreMatchers.is;

import android.view.View;
import android.view.ViewGroup;

import org.junit.rules.ErrorCollector;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.usp.icmc.ppgccmc.accessibility_tests.IAccessibilityTestSelfContained;

public class TestInteractionElementSpacing implements IAccessibilityTestSelfContained {
    @Override
    public void runTest(View rootView, ErrorCollector collector) {
        List<View> interactions = new ArrayList<>();

        // Do something with the root node
        if (rootView != null) {
            LinkedList<View> nodeQueue = new LinkedList<>();
            nodeQueue.add(rootView);
            while (!nodeQueue.isEmpty()) {
                View currentView = nodeQueue.poll();

                if (currentView.isClickable() || currentView.isFocusable() || currentView.isLongClickable()) {
                    interactions.add(currentView);
                }


                // Se for um viewgroup, adiciona views filhas na lista
                if (currentView instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) currentView;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        View child = viewGroup.getChildAt(i);
                        if (child != null) {
                            nodeQueue.add(child);
                        }
                    }
                }
            }

            // Verifica o espaçamento entre cada par de elementos de interação
            checkSpacingBetweenElements(interactions, collector);
        }
    }

    private void checkSpacingBetweenElements(List<View> interactions, ErrorCollector collector) {
        for (int i = 0; i < interactions.size() - 1; i++) {
            for (int j = i + 1; j < interactions.size(); j++) {
                View view1 = interactions.get(i);
                View view2 = interactions.get(j);

                checkSpacingBetweenElements(view1, view2, collector);
            }
        }
    }

    private void checkSpacingBetweenElements(View view1, View view2, ErrorCollector collector) {
        float y1 = view1.getTranslationY() + view1.getHeight() / 2f;
        float x1 = view1.getTranslationX() + view1.getWidth() / 2f;

        float y2 = view2.getTranslationY() + view2.getHeight() / 2f;
        float x2 = view2.getTranslationX() + view2.getWidth() / 2f;

        float distance = (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        collector.checkThat(String.format("Distance between %s and %s is less than 8 pixels", view1, view2), distance >= 8f, is(true));
        //assertTrue(String.format("Distance between %s and %s is less than 8 pixels", view1, view2), distance >= 8f);
    }
}
