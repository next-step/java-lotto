package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningCheckerTest {
    @DisplayName("로또 번호가 당첨 번호와 몇개 일치하는지 확인한다.")
    @Test
    void lottoWinningCheckerTest() {
        // given
        List<Lotto> userBuyLotto = Collections.singletonList(new FakeStrategy(List.of(1, 2, 3, 4, 5, 6)).generate());
        Lotto winLotto = new FakeStrategy(List.of(6, 5, 4, 3, 2, 16)).generate();
        LottoNumber bonusNumber = new LottoNumber(14);

        // when
        LottoWinningChecker lottoWinningChecker = new LottoWinningChecker(userBuyLotto, winLotto, bonusNumber);

        // then
        assertThat(lottoWinningChecker.getRanks().get(LottoPrize.THIRD)).isEqualTo(1);
    }
}
