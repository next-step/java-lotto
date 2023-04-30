package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoRankTest {

    @ParameterizedTest
    @MethodSource("lottoRankProvider")
    void of(int count, LottoRank rank, boolean matchBonus) throws Exception {
        //given

        //when
        LottoRank result = LottoRank.valueOf(count, matchBonus);

        //then
        assertThat(result).isEqualTo(rank);
    }

    static Stream<Arguments> lottoRankProvider() {
        return Stream.of(
                arguments(0, LottoRank.FAIL, false),
                arguments(1, LottoRank.FAIL, false),
                arguments(2, LottoRank.FAIL, false),
                arguments(3, LottoRank.FIFTH, false),
                arguments(4, LottoRank.FOURTH, false),
                arguments(5, LottoRank.THIRD, false),
                arguments(5, LottoRank.SECOND, true),
                arguments(6, LottoRank.FIRST, false)
        );
    }

    @Test
    void calculatePrizeMoney() throws Exception {
        //given
        LottoRank rank = LottoRank.valueOf(4, false);
        int prizeMoney = rank.getPrizeMoney();

        //when
        int result = rank.calculatePrizeMoney(3);

        //then
        assertThat(result).isEqualTo(3 * prizeMoney);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:true", "1:true", "4:false"}, delimiter = ':')
    void isMiss(int count, boolean expected) throws Exception {
        //given
        LottoRank rank = LottoRank.valueOf(count, false);

        //when
        boolean result = rank.isMiss();

        //then
        assertThat(result).isEqualTo(expected);
    }
}
