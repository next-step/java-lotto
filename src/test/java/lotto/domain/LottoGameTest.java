package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {
    @Test
    @DisplayName("게임 결과 계산 로직 테스트")
    public void calculateGameResult() {
        WinningLotto winningLotto = new WinningLotto("3, 4, 5, 6, 7, 8", "9");

        List<Lotto> purchasedLotto = new ArrayList<>();
        purchasedLotto.add(new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)));
        purchasedLotto.add(new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)));
        purchasedLotto.add(new Lotto(Arrays.asList(3, 4, 5, 6, 9, 10)));
        purchasedLotto.add(new Lotto(Arrays.asList(3, 4, 5, 9, 10, 11)));
        purchasedLotto.add(new Lotto(Arrays.asList(3, 4, 5, 9, 10, 11)));

        Map<LottoRank, Long> result = LottoGame.getGameResult(purchasedLotto, winningLotto);

        assertThat(result.get(LottoRank.FOURTH)).isEqualTo(2);
        assertThat(result.get(LottoRank.FIRST)).isEqualTo(2);
        assertThat(result.get(LottoRank.THIRD)).isEqualTo(1);
    }
}