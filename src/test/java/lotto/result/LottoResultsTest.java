package lotto.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultsTest {

    @Test
    @DisplayName("LottoResults 객체를 생성한다")
    void shouldReturnSameObject() {
        LottoResults lottoResults = LottoResults.from(new EnumMap<>(Rank.class), 1);
        assertThat(lottoResults).isEqualTo(LottoResults.from(new EnumMap<>(Rank.class), 1));
    }
}