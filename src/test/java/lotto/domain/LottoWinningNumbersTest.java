package lotto.domain;

import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningNumbersTest {
    @Test
    void create() {
        Lotto winLotto = new Lotto(1,2,3,4,5,6);
        LottoNumber bonusNumber = LottoNumber.valueOf(7);

        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winLotto,bonusNumber);

        Assertions.assertThat(lottoWinningNumbers.getBonusNumber()).isEqualTo(7);
    }

    @Test
    void 로또_지난_주_당첨번호_개수() {
        LottoWinningNumbers lottoWinningNumbers =
                new LottoWinningNumbers(new Lotto(1, 2, 3, 11, 22, 33), LottoNumber.valueOf(44));

        assertThat(
                lottoWinningNumbers.determineRank(new Lotto(1,2,3,4,5,6))
        ).isEqualTo(LottoRank.FIFTH);
    }
}
