package lottery.dto;

import lottery.domain.Prize;

import java.util.Collections;
import java.util.List;

public class RoundResult {

    private final List<Prize> prizes;
    private final double rateOfReturn;

    public RoundResult(List<Prize> prizes, double rateOfReturn) {
        this.prizes = Collections.unmodifiableList(prizes);
        this.rateOfReturn = rateOfReturn;
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
