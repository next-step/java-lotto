package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Revenue {

    private float revenue;
    private static final float BREAK_EVEN_POINT = 1.0f;

    public Revenue(float revenue){
        this.revenue = revenue;
    }

    public float getRevenueStatic() {
        return revenue;
    }

    public String benefitOrLoss() {

        if (revenue < BREAK_EVEN_POINT) {
            return "손해";
        }
        return "이득";
    }

}
