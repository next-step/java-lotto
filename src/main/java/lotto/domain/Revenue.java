package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.LottoController.LOTTO_GAME_PRICE;

public class Revenue {

    private static final float BREAK_EVEN_POINT = 1.0f;
    private static final int ZERO = 0;
    private float revenue;

    public Revenue(long totalSum, int totalGame) {

        if (totalGame == ZERO) {
            throw new IllegalArgumentException("분모가 0일 수 없습니다.");
        }
        this.revenue = totalSum / (totalGame * LOTTO_GAME_PRICE);
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
