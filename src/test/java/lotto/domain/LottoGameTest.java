package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {
    @Test
    @DisplayName("게임 결과 계산 로직 테스트")
    public void calculateGameResult() {
        WinningLotto winningLotto = new WinningLotto("3, 4, 5, 6, 7, 8");

        List<Lotto> purchasedLotto = new ArrayList<>();
        purchasedLotto.add(new Lotto(new Integer[]{3, 4, 5, 6, 7, 8}));
        purchasedLotto.add(new Lotto(new Integer[]{3, 4, 5, 6, 7, 8}));
        purchasedLotto.add(new Lotto(new Integer[]{3, 4, 5, 6, 9, 10}));
        purchasedLotto.add(new Lotto(new Integer[]{3, 4, 5, 9, 10, 11}));
        purchasedLotto.add(new Lotto(new Integer[]{3, 4, 5, 9, 10, 11}));

        Map<Integer, Integer> result = LottoGame.getGameResult(purchasedLotto, winningLotto);

        assertThat(result.get(3)).isEqualTo(2);
        assertThat(result.get(6)).isEqualTo(2);
        assertThat(result.get(4)).isEqualTo(1);
    }

}