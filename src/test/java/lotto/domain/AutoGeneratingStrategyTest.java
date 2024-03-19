package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.Lotto.*;
import static org.assertj.core.api.Assertions.assertThat;

class AutoGeneratingStrategyTest {
    @Nested
    @DisplayName("lottoNumbers() 테스트")
    class LottoNumbersTest {
        LottoNumberGeneratingStrategy lottoNumberGeneratingStrategy = new AutoGeneratingStrategy();
        List<Integer> lottoNumberList = lottoNumberGeneratingStrategy.lottoNumbers();

        @Test
        @DisplayName("생성된 번호의 개수가 LOTTO_NUMBER_COUNT와 동일하다.")
        void testLottoNumberCount() {
            assertThat(lottoNumberList.size()).isEqualTo(LOTTO_NUMBER_COUNT);
        }

        @Test
        @DisplayName("생성된 번호는 MIN_LOTTO_NUMBER 보다 크거나 갇고 MAX_LOTTO_NUMBER 보다 작거나 같다")
        void testLottoNumberRange() {
            for(Integer number : lottoNumberList) {
                assertThat(number).isGreaterThanOrEqualTo(MIN_LOTTO_NUMBER);
                assertThat(number).isLessThanOrEqualTo(MAX_LOTTO_NUMBER);
            }
        }
    }
}
