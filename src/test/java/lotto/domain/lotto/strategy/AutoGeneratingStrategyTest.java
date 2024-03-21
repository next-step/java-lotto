package lotto.domain.lotto.strategy;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.lotto.Lotto.*;
import static lotto.domain.lotto.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.lotto.LottoNumber.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

class AutoGeneratingStrategyTest {
    @Nested
    @DisplayName("lottoNumbers() 테스트")
    class LottoNumbersTest {
        LottoGeneratingStrategy lottoGeneratingStrategy = new AutoGeneratingStrategy();
        Lotto lotto = lottoGeneratingStrategy.lotto();

        @Test
        @DisplayName("생성된 번호의 개수가 LOTTO_NUMBER_COUNT와 동일하다.")
        void testLottoNumberCount() {
            List<LottoNumber> lottoNumbers = lotto.lottoNumbers();
            assertThat(lottoNumbers.size()).isEqualTo(LOTTO_NUMBER_SIZE);
        }

        @Test
        @DisplayName("생성된 번호는 MIN_LOTTO_NUMBER 보다 크거나 갇고 MAX_LOTTO_NUMBER 보다 작거나 같다")
        void testLottoNumberRange() {
            List<LottoNumber> lottoNumbers = lotto.lottoNumbers();

            for (LottoNumber lottoNumber : lottoNumbers) {
                assertThat(lottoNumber.lottoNumber()).isGreaterThanOrEqualTo(MIN_LOTTO_NUMBER);
                assertThat(lottoNumber.lottoNumber()).isLessThanOrEqualTo(MAX_LOTTO_NUMBER);
            }
        }
    }
}
