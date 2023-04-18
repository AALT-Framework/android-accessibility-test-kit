package br.usp.icmc.ppgccmc.accessibility_tests.mars;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

import org.junit.rules.ErrorCollector;

import java.util.LinkedList;

import br.usp.icmc.ppgccmc.accessibility_tests.IAccessibilityTestSelfContained;

public class TestFocusBasedNavigationSuport implements IAccessibilityTestSelfContained {

    @Override
    public void runTest(View rootView, ErrorCollector collector) {
        AccessibilityNodeInfo rootNode = rootView.createAccessibilityNodeInfo();

        int numberOfUnfocusableNodes = 0;

        // Do something with the root node
        if (rootNode != null) {
            LinkedList<AccessibilityNodeInfo> nodeQueue = new LinkedList<>();
            nodeQueue.add(rootNode);
            while (!nodeQueue.isEmpty()) {
                AccessibilityNodeInfo currentNode = nodeQueue.poll();

                if (!currentNode.isAccessibilityFocused()) {
                    numberOfUnfocusableNodes++;
                }
                for (int i = 0; i < currentNode.getChildCount(); i++) {
                    AccessibilityNodeInfo child = currentNode.getChild(i);
                    if (child != null) {
                        nodeQueue.add(child);
                    }
                }
            }
        }

        // Recycle the root node to avoid memory leaks
        rootNode.recycle();

        collector.checkThat("Existem elementos de interação sem suporte para navegação baseada em foco",  numberOfUnfocusableNodes, equalTo(0));
        //assertThat(numberOfUnfocusableNodes, equalTo(0));
    }
}
