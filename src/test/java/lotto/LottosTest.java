package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 개수만큼 Lotto를 갖는다.")
    @Test
    void purchase() {
        int purchasePrice = 15000;
        Lottos lottos = new Lottos(purchasePrice);
        assertThat(lottos.count()).isEqualTo(15);
    }

    @DisplayName("당첨 번호와 로또 번호의 일치 개수에 따라 로또 개수를 집계한다.")
    @Test
    void checkNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        Lottos purchasedLottos = new Lottos(List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(2, 3, 4, 5, 6, 7)),
            new Lotto(List.of(3, 4, 5, 6, 7, 8)),
            new Lotto(List.of(4, 5, 6, 7, 8, 9)),
            new Lotto(List.of(5, 6, 7, 8, 9, 10)),
            new Lotto(List.of(6, 7, 8, 9, 10, 11))
        ));

        Map<Integer, Integer> result = purchasedLottos.countMatchResults(winningLotto);

        assertThat(result).containsEntry(3, 1)
            .containsEntry(4, 1)
            .containsEntry(5, 1)
            .containsEntry(6, 1);
    }
}
