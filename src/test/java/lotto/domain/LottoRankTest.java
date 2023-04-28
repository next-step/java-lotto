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
    void of(int count, LottoRank rank) throws Exception {
        //given

        //when
        LottoRank result = LottoRank.of(count);

        //then
        assertThat(result).isEqualTo(rank);
    }

    static Stream<Arguments> lottoRankProvider() {
        return Stream.of(
                arguments(0, LottoRank.FAIL),
                arguments(1, LottoRank.FAIL),
                arguments(2, LottoRank.FAIL),
                arguments(3, LottoRank.FOURTH),
                arguments(4, LottoRank.THIRD),
                arguments(5, LottoRank.SECOND),
                arguments(6, LottoRank.FIRST)
        );
    }

    @Test
    void calculatePrizeMoney() throws Exception {
        //given
        LottoRank rank = LottoRank.of(4);
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
        LottoRank rank = LottoRank.of(count);

        //when
        boolean result = rank.isMiss();

        //then
        assertThat(result).isEqualTo(expected);
    }
}
