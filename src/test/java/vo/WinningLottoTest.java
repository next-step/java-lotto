package vo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    public void match_first() {
        //Give
        Lotto userLotto = Lotto.of(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.of(7);

        //When
        WinningLotto lotto = new WinningLotto(userLotto, bonusNumber);

        //Then
        assertThat(lotto.match(userLotto)).isEqualTo(Rank.FIRST_PLACE);
    }

    @Test
    public void match_second() {
        //Give
        Lotto userLotto = Lotto.of(1, 2, 3, 4, 5, 7);
        Lotto winningLotto = Lotto.of(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.of(7);

        //When
        WinningLotto lotto = new WinningLotto(winningLotto, bonusNumber);

        //Then
        assertThat(lotto.match(userLotto)).isEqualTo(Rank.SECOND_PLACE);
    }

    @Test
    public void match_miss() {
        //Give
        Lotto userLotto = Lotto.of(1, 2, 3, 4, 5, 7);
        Lotto winningLotto = Lotto.of(1, 2, 8, 9, 10, 11);
        LottoNumber bonusNumber = LottoNumber.of(7);

        //When
        WinningLotto lotto = new WinningLotto(winningLotto, bonusNumber);

        //Then
        assertThat(lotto.match(userLotto)).isEqualTo(Rank.FAILURE);
    }
}