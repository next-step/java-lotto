package lotto.domain;

import lotto.LottoErrorMessage;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum PrizeUnit {

    FOURTH_GRADE(3, 5000, (value, unitMoney) -> Long.valueOf(value * unitMoney)),
    THIRD_GRADE(4, 50000, (value, unitMoney) -> Long.valueOf(value * unitMoney)),
    SECOND_GRADE(5, 1500000, (value, unitMoney) -> Long.valueOf(value * unitMoney)),
    FIRST_GRADE(6, 2000000000, (value, unitMoney) -> Long.valueOf(value * unitMoney));

    public int prizeUnitCount;
    public int prizeUnitMoney;
    private BiFunction<Integer, Integer, Long> expression;

    PrizeUnit(int prizeUnitCount, int prizeUnitMoney, BiFunction<Integer, Integer, Long> expression){
        this.prizeUnitCount = prizeUnitCount;
        this.prizeUnitMoney = prizeUnitMoney;
        this.expression = expression;
    }

    public static PrizeUnit findPrizeFieldByUnitCount(int unitCount){
        return Arrays.stream(PrizeUnit.values())
                .filter(prize -> prize.prizeUnitCount == unitCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(LottoErrorMessage.NOT_PRIZE_UNIT.getErrorMessage()));
    }


    public static Long calculate(int unitCount, int winningTicketCount){
        PrizeUnit unit = findPrizeFieldByUnitCount(unitCount);
        return unit.expression.apply(winningTicketCount, unit.prizeUnitMoney);
    }

}
