package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoNumbers;
import lotto.lotto.Lottos;
import lotto.result.LottoResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static lotto.result.MatchedNumbersCount.FOUR;
import static lotto.result.MatchedNumbersCount.THREE;
import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("Lottos 객체를 생성한다")
    void shouldCreateSameObject() {
        Lottos lottos = lottos();
        assertThat(lottos).isEqualTo(lottos());
    }

    @Test
    @DisplayName("구매한 금액만큼 Lottos 객체를 생성한다")
    void shouldCreateWithPurchaseAmount() {
        Lottos lottos = Lottos.from(10000);
        assertThat(lottos.values().size()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또 번호가 주어진 개수만큼 일치하는 로또의 개수를 구한다")
    void shouldReturnCount() {
        Lottos lottos = lottos();
        int purchaseAmount = 2000;
        LottoNumbers winningNumbers = winningNumbers();

        LottoResults lottoResults = lottos.result(winningNumbers, purchaseAmount);
        assertThat(lottoResults.matchedNumbersCount(THREE)).isEqualTo(1L);
        assertThat(lottoResults.matchedNumbersCount(FOUR)).isEqualTo(1L);
    }

    private Lottos lottos() {
        return Lottos.from(asList(
                Lotto.from(asList(1, 2, 3, 7, 8, 9)),
                Lotto.from(asList(1, 2, 3, 4, 7, 8)))
        );
    }

    private LottoNumbers winningNumbers() {
        return LottoNumbers.from(asList(1, 2, 3, 4, 5, 6));
    }
}