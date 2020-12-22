package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    @Test
    @DisplayName("로또 열개 생성")
    void generateLottos() {
        Lottos lottos = new Lottos();
        Lottos generateLottos = lottos.generateAutoLottos(10);
        assertThat(generateLottos.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("당첨로또 확인 : 당첨 안된 로또")
    void no_match_test() {
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.of(Arrays.asList(3, 4, 22, 36, 39, 45)), Lotto.of(Arrays.asList(7, 11, 14, 15, 35, 38))
        ));

        Lotto winLotto = Lotto.of(Arrays.asList(1, 2, 5, 10, 34, 43));
        LottoNumber bonumsNumber = LottoNumber.of("3");
        WinningLotto winningLotto = new WinningLotto(winLotto, bonumsNumber);
        Map<WinType, Integer> results = lottos.matchWinning(winningLotto);
        Assertions.assertThat(results).containsEntry(WinType.NO_MATCH, 2);
    }

    @Test
    @DisplayName("당첨로또 확인 : 3자리 맞춤")
    void three_match_test() {
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.of(Arrays.asList(1, 2, 5, 6, 9, 10)), Lotto.of(Arrays.asList(2, 7, 10, 13, 34, 41))
        ));

        Lotto winLotto = Lotto.of(Arrays.asList(2, 7, 10, 33, 44));
        LottoNumber bonumsNumber = LottoNumber.of("3");
        WinningLotto winningLotto = new WinningLotto(winLotto, bonumsNumber);
        Map<WinType, Integer> results = lottos.matchWinning(winningLotto);
        Assertions.assertThat(results).containsEntry(WinType.THREE_MATCH, 1);
    }

    @Test
    @DisplayName("당첨로또 확인 : 4자리 맞춤")
    void four_match_test() {
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.of(Arrays.asList(3, 4, 5, 10, 34, 43)), Lotto.of(Arrays.asList(7, 11, 14, 15, 35, 38))
        ));
        Lotto winLotto = Lotto.of(Arrays.asList(1, 2, 5, 10, 34, 43));
        LottoNumber bonumsNumber = LottoNumber.of("3");
        WinningLotto winningLotto = new WinningLotto(winLotto, bonumsNumber);
        Map<WinType, Integer> results = lottos.matchWinning(winningLotto);
        Assertions.assertThat(results).containsEntry(WinType.FOUR_MATCH, 1);
    }

    @Test
    @DisplayName("당첨로또 확인 : 5자리 맞춤")
    void five_match_test() {
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.of(Arrays.asList(1, 2, 5, 10, 34, 43)), Lotto.of(Arrays.asList(7, 11, 14, 15, 35, 38))
        ));

        Lotto winLotto = Lotto.of(Arrays.asList(1, 2, 5, 10, 34, 40));
        LottoNumber bonumsNumber = LottoNumber.of("3");
        WinningLotto winningLotto = new WinningLotto(winLotto, bonumsNumber);
        Map<WinType, Integer> results = lottos.matchWinning(winningLotto);
        Assertions.assertThat(results).containsEntry(WinType.FIVE_MATCH, 1);
    }

    @Test
    @DisplayName("당첨로또 확인 : 5자리 + 보너스 수 맞춤")
    void bonus_match_test() {
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.of(Arrays.asList(1, 2, 5, 10, 34, 3)), Lotto.of(Arrays.asList(7, 11, 14, 15, 35, 38))
        ));

        Lotto winLotto = Lotto.of(Arrays.asList(1, 2, 5, 10, 34, 43));
        LottoNumber bonumsNumber = LottoNumber.of("3");
        WinningLotto winningLotto = new WinningLotto(winLotto, bonumsNumber);

        Map<WinType, Integer> results = lottos.matchWinning(winningLotto);
        Assertions.assertThat(results).containsEntry(WinType.BONUMS_MATCH, 1);
    }

    @Test
    @DisplayName("당첨로또 확인 : 6자리 맞춤")
    void six_match_test() {
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.of(Arrays.asList(1, 2, 4, 6, 9, 10)),
                Lotto.of(Arrays.asList(7, 11, 14, 15, 35, 38)),
                Lotto.of(Arrays.asList(7, 11, 14, 15, 35, 2))
        ));

        Lotto winLotto = Lotto.of(Arrays.asList(1, 2, 4, 6, 9, 10));
        LottoNumber bonumsNumber = LottoNumber.of("38");
        WinningLotto winningLotto = new WinningLotto(winLotto, bonumsNumber);
        Map<WinType, Integer> results = lottos.matchWinning(winningLotto);
        Assertions.assertThat(results).containsEntry(WinType.SIX_MATCH, 1);
    }
}
