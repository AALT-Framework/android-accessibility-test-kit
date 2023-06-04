package br.usp.icmc.ppgccmc.accessibility_tests.helpers;

import android.content.res.Resources;
import android.view.View;

public class TestOutputHelper {
    public static String getViewId(View view){
        try {
            final Resources resources = view.getResources();
            final String resourceName = resources.getResourceName(view.getId());
            final String[] split = resourceName.split(":");
            if(split != null)
                return split[split.length-1];

            return resourceName;
        }catch (Exception ex) {
            return view.toString();
        }
    }
}
