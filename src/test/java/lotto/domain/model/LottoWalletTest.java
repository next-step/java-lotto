package lotto.domain.model;

import lotto.domain.service.LottoResultCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWalletTest {
    @DisplayName("로또를 추가한다.")
    @Test
    void addTest() {
        LottoTicket lotto1 = new LottoTicket(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        LottoTicket lotto2 = new LottoTicket(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(7)
        ));

        LottoWallet lottoWallet = new LottoWallet();
        lottoWallet.addLotto(lotto1);
        lottoWallet.addLotto(lotto2);

        List<LottoTicket> lottos = lottoWallet.getLottos();
        assertThat(lottos).containsExactlyInAnyOrder(lotto1, lotto2);
        assertThat(lottoWallet.getCount()).isEqualTo(2);
    }

    @DisplayName("로또 번호를 비교하여 일치하는 개수를 센다.")
    @Test
    void countMatchTest() {
        List<LottoNumber> winNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );

        LottoNumber bonusNumber = new LottoNumber(7);
        WinningTicket winningTicket = new WinningTicket(winNumbers, bonusNumber);

        LottoWallet lottoWallet = new LottoWallet();
        lottoWallet.addLotto(new LottoTicket(List.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )));
        lottoWallet.addLotto(new LottoTicket(List.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(7)
                )));

        MatchResult matchResult = lottoWallet.countMatches(winningTicket);

        assertThat(matchResult.getCount(Rank.FIRST)).isEqualTo(1);
        assertThat(matchResult.getCount(Rank.SECOND)).isEqualTo(1);
        assertThat(matchResult.getCount(Rank.THIRD)).isEqualTo(0);
        assertThat(matchResult.getCount(Rank.FOURTH)).isEqualTo(0);
        assertThat(matchResult.getCount(Rank.FIFTH)).isEqualTo(0);
        assertThat(matchResult.getCount(Rank.MISS)).isEqualTo(0);
    }
}
