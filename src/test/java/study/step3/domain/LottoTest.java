package study.step3.domain;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 당첨_계산() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(3, 5, 6, 9, 23, 43));
        LottoNumber bonusNumber = new LottoNumber(7);
        Rank rank = lotto.matches(winningNumbers, bonusNumber);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 이등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        Rank rank = lotto.matches(winningNumbers, bonusNumber);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
