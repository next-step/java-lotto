package lotto.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum PrizeUnit {

    FIRST_GRADE(6,2000000000, (value, unitMoney) -> Long.valueOf(value * unitMoney)),
    SECOND_GRADE(5, 30000000, (value, unitMoney) -> Long.valueOf(value * unitMoney)),
    THIRD_GRADE(5, 1500000, (value, unitMoney) -> Long.valueOf(value * unitMoney)),
    FOURTH_GRADE(4, 50000, (value, unitMoney) -> Long.valueOf(value * unitMoney)),
    FIFTH_GRADE(3,  5000, (value, unitMoney) -> Long.valueOf(value * unitMoney));


    public int prizeUnitCount;

    public int prizeUnitMoney;
    private BiFunction<Integer, Integer, Long> expression;

    PrizeUnit(int prizeUnitCount, int prizeUnitMoney, BiFunction<Integer, Integer, Long> expression){
        this.prizeUnitCount = prizeUnitCount;
        this.prizeUnitMoney = prizeUnitMoney;
        this.expression = expression;
    }

    public static PrizeUnit findPrizeFieldByUnitCount(int unitCount, boolean matchBonus){
        if(unitCount == SECOND_GRADE.prizeUnitCount && matchBonus){
            return SECOND_GRADE;
        }

        return Arrays.stream(PrizeUnit.values())
                .filter(prize -> prize != SECOND_GRADE)
                .filter(prize -> prize.prizeUnitCount == unitCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(LottoErrorMessage.NOT_PRIZE_UNIT.getErrorMessage()));
    }


    public static Long calculate(int unitCount, boolean matchBonus, int winningTicketCount){
        PrizeUnit unit = findPrizeFieldByUnitCount(unitCount, matchBonus);
        return unit.expression.apply(winningTicketCount, unit.prizeUnitMoney);
    }


}
