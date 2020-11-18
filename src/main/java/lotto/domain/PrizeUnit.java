package lotto.domain;

import lotto.LottoErrorMessage;

import java.util.Arrays;
import java.util.function.Function;

public enum PrizeUnit {

    FOURTH_GRADE(3, value -> Long.valueOf(value * 5000)),
    THIRD_GRADE(4, value -> Long.valueOf(value * 50000)),
    SECOND_GRADE(5, value -> Long.valueOf(value * 1500000)),
    FIRST_GRADE(6, value -> Long.valueOf(value * 2000000000));

    public int prizeUnitCount;
    private Function<Integer, Long> expression;

    PrizeUnit(int prizeUnitCount, Function<Integer, Long> expression){
        this.prizeUnitCount = prizeUnitCount;
        this.expression = expression;
    }

    public static PrizeUnit findPrizeFieldByUnitCount(int unitCount){
        return Arrays.stream(PrizeUnit.values())
                .filter(prize -> prize.prizeUnitCount == unitCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(LottoErrorMessage.NOT_PRIZE_UNIT.getErrorMessage()));
    }


    public static Long calculate(int unitCount, int winningTicketCount){
        return findPrizeFieldByUnitCount(unitCount).expression.apply(winningTicketCount);
    }

}
