package lotto.domain.lotto.strategy;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.domain.lotto.Lotto.LOTTO_NUMBER_SIZE;
import static lotto.domain.lotto.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.lotto.LottoNumber.MIN_LOTTO_NUMBER;
import static lotto.domain.lotto.strategy.LottoGeneratingStrategy.EMPTY_LOTTOS;
import static org.assertj.core.api.Assertions.assertThat;

class AutoGeneratingStrategyTest {
    LottoGeneratingStrategy lottoGeneratingStrategy = new AutoGeneratingStrategy();

    @Nested
    @DisplayName("lottos() 테스트")
    class LottosTest {
        @ParameterizedTest
        @ValueSource(ints = {1, 3, 6})
        @DisplayName("totalNumberOfLottoToPurchase 만큼 Lotto가 생성된다.")
        void testSizeOfLottos(int totalNumberOfLottoToPurchase) {
            Lottos lottos = lottoGeneratingStrategy.lottos(totalNumberOfLottoToPurchase, EMPTY_LOTTOS);
            assertThat(lottos.lottos().size()).isEqualTo(totalNumberOfLottoToPurchase);
        }

        @Nested
        @DisplayName("생성된 Lotto에 대한 테스트")
        class LottoTest {
            Lotto lotto = lottoGeneratingStrategy.lottos(1, EMPTY_LOTTOS)
                    .lottos()
                    .get(0);

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
}
