package step2;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.model.LottoWin;

public class LottoWinTest {


  @Test
  public void Lotto_winner_count_test() {
    LottoWin lottoWin = new LottoWin();
    lottoWin.countUpFirstWinner();
    lottoWin.countUpSecondWinner();
    lottoWin.countUpThirdWinner();
    lottoWin.countUpFourthWinner();

    assertThat(lottoWin.getFirstWinnerCount()).isEqualTo(1);
    assertThat(lottoWin.getSecondWinnerCount()).isEqualTo(1);
    assertThat(lottoWin.getThirdWinnerCount()).isEqualTo(1);
    assertThat(lottoWin.getFourthWinnerCount()).isEqualTo(1);
  }

  @ParameterizedTest
  @ValueSource(ints = {10, 100, 100, 1000})
  public void Lotto_winner_count_test(int winnerCount) {
    LottoWin lottoWin = new LottoWin(winnerCount, winnerCount, winnerCount, winnerCount);

    assertThat(lottoWin.getFirstWinnerCount()).isEqualTo(winnerCount);
    assertThat(lottoWin.getSecondWinnerCount()).isEqualTo(winnerCount);
    assertThat(lottoWin.getThirdWinnerCount()).isEqualTo(winnerCount);
    assertThat(lottoWin.getFourthWinnerCount()).isEqualTo(winnerCount);
  }
}
