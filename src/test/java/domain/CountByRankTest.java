package domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CountByRankTest {
    @Test
    void create() {
        //given
        Map<Rank, Integer> countByRank = TestObjectSupport.createRankIntegerMap();

        //when
        CountByRank result = new CountByRank(countByRank);

        //then
        assertThat(result).isEqualTo(new CountByRank(countByRank));
    }

    @Test
    void createByStaticFactoryMethod() {
        //given
        CountByRank expectedCountByRank = new CountByRank(TestObjectSupport.createRankIntegerMap());

        //when
        CountByRank result = CountByRank.create();

        //then
        assertThat(result).isEqualTo(expectedCountByRank);
    }

    @Test
    void increaseCount() {
        //given
        CountByRank countByRank = CountByRank.create();
        Map<Rank, Integer> rankIntegerMap = TestObjectSupport.createRankIntegerMap();
        rankIntegerMap.replace(Rank.FIRST, 1);
        CountByRank expectedCountByRank = new CountByRank(rankIntegerMap);

        //when
        CountByRank result = countByRank.increaseCount(Rank.FIRST);

        //then
        assertThat(result).isEqualTo(expectedCountByRank);
    }

    @Test
    void winningMoney() {
        //given
        CountByRank countByRank = CountByRank.create().increaseCount(Rank.FIRST).increaseCount(Rank.SECOND);
        BigDecimal expectedWinningMoney = Rank.FIRST.getWinningMoney().add(Rank.SECOND.getWinningMoney());

        //when
        BigDecimal result = countByRank.winningMoney();

        //then
        assertThat(result).isEqualByComparingTo(expectedWinningMoney);
    }

    @Test
    void count() {
        //given
        CountByRank countByRank = CountByRank.create().increaseCount(Rank.FIRST);

        //when
        int result = countByRank.count(Rank.FIRST);

        //then
        assertThat(result).isEqualTo(1);
    }
}
