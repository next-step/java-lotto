package lotto.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultsTest {

    @Test
    @DisplayName("LottoResults 객체를 생성한다")
    void shouldReturnSameObject() {
        Map<MatchedNumbersCount, Long> lottoResults = new EnumMap<>(MatchedNumbersCount.class);
        LottoResults newLottoResults = new LottoResults(lottoResults);

        assertThat(newLottoResults).isEqualTo(new LottoResults(lottoResults));
    }

    @Test
    @DisplayName("로또 결과를 추가한다")
    void shouldAddElement() {
        Map<MatchedNumbersCount, Long> lottoResults = new EnumMap<>(MatchedNumbersCount.class);
        LottoResults newLottoResults = new LottoResults(lottoResults);
        MatchedNumbersCount matchedNumbersCount = MatchedNumbersCount.THREE;
        newLottoResults.add(matchedNumbersCount, 3);

        assertThat(newLottoResults.values().get(matchedNumbersCount)).isEqualTo(3);
    }
}