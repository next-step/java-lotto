package domain;

import org.junit.jupiter.api.Test;

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
}
