package lotto.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum PrizeUnit {

    FIRST_GRADE(6,2000000000, (value) -> Long.valueOf(value * 2000000000)),
    SECOND_GRADE(5, 30000000, (value) -> Long.valueOf(value * 30000000)),
    THIRD_GRADE(5, 1500000, (value) -> Long.valueOf(value * 1500000)),
    FOURTH_GRADE(4, 50000, (value) -> Long.valueOf(value * 50000)),
    FIFTH_GRADE(3,  5000, (value) -> Long.valueOf(value * 5000)),
    FAIL_GRADE(0,  0, (value) -> Long.valueOf(value * 0));

    private static final int MIN_COUNT_TO_PRIZE = 3;

    public int prizeUnitCount;

    public int prizeUnitMoney;

    private Function<Integer, Long> expression;

    PrizeUnit(int prizeUnitCount, int prizeUnitMoney, Function<Integer, Long> expression){
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
                .filter(prize -> prize.prizeUnitCount == (unitCount < MIN_COUNT_TO_PRIZE ? 0 : unitCount))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(LottoErrorMessage.NOT_PRIZE_UNIT.getErrorMessage()));
    }

    public Long calculate(int winningTicketCount){
        return expression.apply(winningTicketCount);
    }
}
