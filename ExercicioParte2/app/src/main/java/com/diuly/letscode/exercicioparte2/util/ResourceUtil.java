package com.diuly.letscode.exercicioparte2.util;

import com.diuly.letscode.exercicioparte2.R;
import com.diuly.letscode.exercicioparte2.model.Affiliation;

/**
 * Created by letscode on 18/11/2017.
 */

public class ResourceUtil {
    public static int getResourceBasedOnAffiliation(Affiliation affiliation) {
        switch (affiliation) {
            case GALACTIC_EMPIRE:
                return R.drawable.galactic_empire;
            case GALACTIC_REPUBLIC:
                return R.drawable.galactic_republic;
            case FIRST_ORDER:
                return R.drawable.first_order;
            default:
                return 0;
        }
    }
}
