package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.Lottos;
import lotto.lotto.lottonumber.LottoNumbers;
import lotto.result.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Arrays.asList;
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
    @DisplayName("당첨 번호와 로또 번호가 일치하는 개수를 구한다")
    void shouldReturnCount() {
        Lottos lottos = lottos();
        LottoNumbers winningNumbers = winningNumbers();
        Map<Rank, Long> result = lottos.match(winningNumbers);

        assertThat(result.get(Rank.findBy(3))).isEqualTo(1);
        assertThat(result.get(Rank.findBy(4))).isEqualTo(2);
    }

    private Lottos lottos() {
        return Lottos.from(asList(
                Lotto.from(asList(1, 2, 3, 7, 8, 9)),
                Lotto.from(asList(1, 2, 3, 7, 8, 10)),
                Lotto.from(asList(1, 2, 3, 4, 7, 8)))
        );
    }

    private LottoNumbers winningNumbers() {
        return LottoNumbers.from(asList(1, 2, 3, 4, 5, 10));
    }
}