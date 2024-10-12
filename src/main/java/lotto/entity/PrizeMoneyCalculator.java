package lotto.entity;

import lotto.dto.RankDto;
import lotto.dto.ResultDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class PrizeMoneyCalculator {

    private final List<RankDto> rankDtos;

    public PrizeMoneyCalculator() {
        rankDtos = Arrays.asList(
                new RankDto(PrizeMoney.THREE),
                new RankDto(PrizeMoney.FOUR),
                new RankDto(PrizeMoney.FIVE),
                new RankDto(PrizeMoney.SIX)
        );
    }

    public ResultDto result(List<PrizeMoney> winners, int inputMoney) {
        BigDecimal winnerMoney = BigDecimal.valueOf(0);

        for (PrizeMoney prizeMoney : winners) {
            winnerMoney = calculate(winnerMoney, prizeMoney);
            increase(prizeMoney);
        }

        BigDecimal rate = calculateRate(inputMoney, winnerMoney);
        return new ResultDto(rankDtos, rate);
    }

    private BigDecimal calculate(BigDecimal winner, PrizeMoney prizeMoney) {
        return prizeMoney.sum(winner);
    }

    private void increase(PrizeMoney prizeMoney) {
        RankDto rankDto = search(prizeMoney);
        rankDto.increase();
    }

    private RankDto search(PrizeMoney prizeMoney) {
        return rankDtos.stream().filter(i -> i.same(prizeMoney.getCount())).findFirst().get();
    }

    private BigDecimal calculateRate(int inputMoney, BigDecimal winnerMoney) {
        return winnerMoney.divide(BigDecimal.valueOf(inputMoney), 2, RoundingMode.HALF_UP);
    }

}
