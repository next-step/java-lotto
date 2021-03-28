package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class HitResults {
    private final static int PAY_MONEY_INIT = 0;

    private final List<HitResult> hitResults;
    private final int payMoney;

    public HitResults() {
        this(PAY_MONEY_INIT);
    }

    public HitResults(int payMoney) {
        this.payMoney = payMoney;
        this.hitResults = new ArrayList<>();
    }

    public void add(HitResult hitResult) {
        this.hitResults.add(hitResult);
    }

    public int getPayMoney() {
        return this.payMoney;
    }

    public List<HitResult> getHitResults() {
        return this.hitResults;
    }
}
