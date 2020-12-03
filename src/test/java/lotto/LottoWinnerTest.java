package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinnerTest {

    @Test
    public void isContainBonusNumberTrue() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        Lotto lotto = new Lotto(lottoNumbers);
        int bonusLottoNumber = 7;
        assertThat(LottoWinner.isContainBonusNumber(lotto, bonusLottoNumber)).isTrue();
    }

    @Test
    public void isContainBonusNumberFalse() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        int bonusLottoNumber = 7;
        assertThat(LottoWinner.isContainBonusNumber(lotto, bonusLottoNumber)).isFalse();
    }
}
