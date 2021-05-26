package lotto;

import lotto.model.LottoNumbers;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    private WinningLotto winningLotto;

    @BeforeEach
    public void setup(){
        winningLotto = new WinningLotto(new LottoNumbers("1,2,3,4,5,6"));
    }

    @Test
    @DisplayName("5등 결과 확인")
    public void fifthRanking() {
        LottoNumbers lottoNumbers = new LottoNumbers("1,2,3,10,20,30");
        assertThat(winningLotto.correctCount(lottoNumbers) == 3).isTrue();
    }

    @Test
    @DisplayName("4등 결과 확인")
    public void fourthRanking() {
        LottoNumbers lottoNumbers = new LottoNumbers("1,2,3,4,10,20");
        assertThat(winningLotto.correctCount(lottoNumbers) == 4).isTrue();
    }

    @Test
    @DisplayName("3등 결과 확인")
    public void thirdRanking() {
        LottoNumbers lottoNumbers = new LottoNumbers("1,2,3,4,5,10");
        assertThat(winningLotto.correctCount(lottoNumbers) == 5).isTrue();
    }

    @Test
    @DisplayName("1등 결과 확인")
    public void firstRanking() {
        LottoNumbers lottoNumbers = new LottoNumbers("1,2,3,4,5,6");
        assertThat(winningLotto.correctCount(lottoNumbers) == 6).isTrue();
    }
}
