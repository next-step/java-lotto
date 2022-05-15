package domain;

import org.junit.jupiter.api.Test;

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
        Winner winner = new Winner(TestObjectSupport.createLottoNumbers());
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
}
