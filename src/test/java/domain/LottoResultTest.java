package domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @Test
    void create() {
        //given
        CountByRank countByRank = CountByRank.create();
        Cash cash = new Cash(4000);

        //when
        LottoResult result = new LottoResult(countByRank, cash);

        //then
        assertThat(result).isEqualTo(new LottoResult(countByRank, cash));
    }

    @Test
    void createByStaticFactoryMethod() {
        //given
        Winner winner = new Winner(TestObjectSupport.createLottoNumbers(), null);
        Lottos lottos = TestObjectSupport.createLottos();
        Map<Rank, Integer> rankIntegerMap = TestObjectSupport.createRankIntegerMap();
        rankIntegerMap.replace(Rank.FIRST, 3);
        CountByRank expectedCountByRank = new CountByRank(rankIntegerMap);
        Cash expectedCash = new Cash(3000);
        LottoResult expectedLottoResult = new LottoResult(expectedCountByRank, expectedCash);

        //when
        LottoResult result = LottoResult.create(winner, lottos);

        //then
        assertThat(result).isEqualTo(expectedLottoResult);
    }

    @Test
    void winningRate() {
        //given
        LottoResult lottoResult = LottoResult.create(TestObjectSupport.createWinner(), TestObjectSupport.createLottos());
        BigDecimal expectedWinningRate = BigDecimal.valueOf(2000000000)
                .multiply(BigDecimal.valueOf(3))
                .divide(BigDecimal.valueOf(3000), 2, RoundingMode.HALF_UP);

        //when
        BigDecimal result = lottoResult.winningRate();

        //then
        assertThat(result).isEqualByComparingTo(expectedWinningRate);
    }

    @Test
    void count() {
        //given
        LottoResult lottoResult = LottoResult.create(TestObjectSupport.createWinner(), TestObjectSupport.createLottos());

        //when
        int result = lottoResult.count(Rank.FIRST);

        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void isGain() {
        //given
        LottoResult lottoResult = LottoResult.create(TestObjectSupport.createWinner(), TestObjectSupport.createLottos());

        //when
        boolean result = lottoResult.isGain();

        //then
        assertThat(result).isTrue();
    }
}
