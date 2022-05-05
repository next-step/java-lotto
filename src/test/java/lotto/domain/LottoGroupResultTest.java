package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGroupResultTest {
    @ParameterizedTest
    @MethodSource("generateLottoResultData")
    void getEarningRatio_총수익률_계산(Map<LottoRank, Integer> lottoGroupResultMap, int totalPrice, double earningRatio) {
        LottoGroupResult lottoGroupResult = new LottoGroupResult(lottoGroupResultMap);
        assertThat(lottoGroupResult.getEarningRatio(totalPrice)).isEqualTo(earningRatio);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "FIRST, 3",
            "SECOND, 2"
    })
    void getLottoMatchCount_해당등수의_로또_카운트(String rankString, int count) {
        LottoRank lottoRank = LottoRank.valueOf(rankString);
        LottoGroupResult lottoGroupResult = new LottoGroupResult(Map.of(
                lottoRank, count
        ));
        assertThat(lottoGroupResult.getLottoMatchCount(lottoRank)).isEqualTo(count);
    }

    @ParameterizedTest
    @NullSource
    void LottoGroupResult_로또_그룹_결과가_null_인_경우(Map<LottoRank, Integer> lottoGroupResult ) {
        assertThatThrownBy(() -> new LottoGroupResult(lottoGroupResult)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateLottoResultData() {
        return Stream.of(
                Arguments.of(Map.of(LottoRank.FOURTH, 1), 14000, 0.35),
                Arguments.of(Map.of(), 0, 1.00),
                Arguments.of(Map.of(
                        LottoRank.FIRST, 1
                ), 1000, 2000000.00),
                Arguments.of(Map.of(
                        LottoRank.FOURTH, 3,
                        LottoRank.MISS, 2
                ), 20000, 0.75),
                Arguments.of(Map.of(
                        LottoRank.FOURTH, 3,
                        LottoRank.THIRD, 1
                ), 20000, 3.25)
        );
    }
}