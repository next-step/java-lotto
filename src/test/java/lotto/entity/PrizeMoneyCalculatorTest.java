package lotto.entity;

import lotto.dto.RankDto;
import lotto.dto.ResultDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeMoneyCalculatorTest {
    @Test
    void 당첨_갯수_검증() {

        int money = 14000;
        List<PrizeMoney> winners = Arrays.asList(
                PrizeMoney.THREE,
                PrizeMoney.THREE,
                PrizeMoney.THREE
        );

        PrizeMoneyCalculator calculator = new PrizeMoneyCalculator();
        ResultDto resultsDtos = calculator.result(winners, money);

        RankDto rankDto = resultsDtos.getRankDtos().stream().filter(i -> i.getPrizeMoney() == PrizeMoney.THREE).findFirst().get();

        assertThat(rankDto.getCount()).isEqualTo(3);
    }
}
