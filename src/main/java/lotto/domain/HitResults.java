package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class HitResults {
    private final List<HitResult> hitResults;
    private final int payMoney;

    public HitResults() {
        this(0);
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
