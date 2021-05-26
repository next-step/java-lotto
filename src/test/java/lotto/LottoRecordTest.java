package lotto;

import org.junit.jupiter.api.DisplayName;
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
}
