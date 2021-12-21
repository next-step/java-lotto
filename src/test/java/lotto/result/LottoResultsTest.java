package lotto.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static lotto.result.MatchedNumbersCount.THREE;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultsTest {

    @Test
    @DisplayName("LottoResults 객체를 생성한다")
    void shouldReturnSameObject() {
        LottoResults lottoResults = LottoResults.from(new EnumMap<>(MatchedNumbersCount.class), 1);
        assertThat(lottoResults).isEqualTo(LottoResults.from(new EnumMap<>(MatchedNumbersCount.class), 1));
    }

    @Test
    @DisplayName("로또 결과를 추가한다")
    void shouldAddElement() {
        LottoResults lottoResults = LottoResults.from(new EnumMap<>(MatchedNumbersCount.class), 1);
        lottoResults.add(THREE, 3);

        assertThat(lottoResults.values().get(THREE)).isEqualTo(3);
    }
}