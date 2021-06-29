package lottoAuto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    private WinningLotto winningLottoTest;

    @BeforeEach
    public void set(){
        Set<LottoNumber> winningNumbers = new HashSet<>();
        winningNumbers.add(new LottoNumber(1));
        winningNumbers.add(new LottoNumber(2));
        winningNumbers.add(new LottoNumber(3));
        winningNumbers.add(new LottoNumber(4));
        winningNumbers.add(new LottoNumber(5));
        winningNumbers.add(new LottoNumber(6));
        Lotto winningLotto = new Lotto(winningNumbers);
        winningLottoTest = new WinningLotto(winningLotto,7);
    }

    @DisplayName("로또 당첨 번호와 몇개나 일치하는지 구할 수 있다.")
    @Test
    public void countWinningLottoNumbers(){
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(7));

        int count = winningLottoTest.countWinningLottoNumbers(lottoNumbers);
        assertThat(count).isEqualTo(5);
    }

    @DisplayName("보너스 볼을 포함하고 있는지 알 수 있다.")
    @Test
    public void hashBonusBallTest(){
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(7));

        boolean result = winningLottoTest.hasBonusBall(lottoNumbers);
        assertThat(result).isEqualTo(true);
    }
}
