package lotto;

import lotto.entity.Lotto;
import lotto.entity.LottoNumber;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    @DisplayName("당첨 번호화 로또 번호가 일치하지 않는 경우")
    public void 당첨번호_로또번호_일치하지_않음() {
        Lotto lottoTicket = new Lotto(InputView.inputNumberChangeArray("1, 2, 3, 4, 5, 6").map(LottoNumber::new).collect(Collectors.toList()));
        Lotto winningLotto = new Lotto(InputView.inputNumberChangeArray("7, 8, 9, 10, 11, 12").map(LottoNumber::new).collect(Collectors.toList()));

        int matchCount = lottoTicket.matchCount(winningLotto);

        assertThat(matchCount).isEqualTo(0);
    }

    @Test
    @DisplayName("당첨 번호화 로또 번호가 일치하는 경우")
    public void 당첨번호_로또번호_일치하지() {
        Lotto lottoTicket = new Lotto(InputView.inputNumberChangeArray("1, 2, 3, 4, 5, 6").map(LottoNumber::new).collect(Collectors.toList()));
        Lotto winningLotto = new Lotto(InputView.inputNumberChangeArray("1, 2, 3, 10, 11, 12").map(LottoNumber::new).collect(Collectors.toList()));

        int matchCount = lottoTicket.matchCount(winningLotto);

        assertThat(matchCount).isEqualTo(3);

    }
}
