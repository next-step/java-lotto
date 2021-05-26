package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoRecordTest {
    @DisplayName("랭크를 상태로 갖는 레코드 테스트")
    @ParameterizedTest
    @MethodSource("recordArgument")
    void 레코드_테스트(LottoRank lottoRank, int expected) {
        LottoRecord lottoRecord = new LottoRecord();
        lottoRecord.recordRank(lottoRank);
        assertThat(lottoRecord.isRecord(lottoRank, expected)).isTrue();
    }

    static Stream<Arguments> recordArgument() {
        return Stream.of(
                Arguments.of(FIRST, 1),
                Arguments.of(SECOND, 1),
                Arguments.of(THIRD, 1),
                Arguments.of(FOURTH, 1)
        );
    }

    @DisplayName("수익률 테스트")
    @ParameterizedTest
    @MethodSource("isProfit")
    void isProfit_수익률_검증(LottoRank lottoRank, int lottoCount, double expected){
        LottoRecord lottoRecord = new LottoRecord();
        lottoRecord.recordRank(lottoRank);
        lottoRecord.calculateProfit(lottoCount);
        assertThat(lottoRecord.isProfit(expected)).isTrue();
    }

    static Stream<Arguments> isProfit() {
        return Stream.of(
                Arguments.of(FOURTH, 14, 0.35),
                Arguments.of(FOURTH, 25, 0.2)
        );
    }
}
