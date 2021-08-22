package step2;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import step2.model.Lotto;
import step2.model.LottoWin;

public class LottoWinTest {


  @Test
  public void Lotto_1등_추첨_테스트() {
    List lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    Lotto lotto = new Lotto(lottoNumber);

    String[] lottowinningNumbers = {"1", "2", "3", "4", "5", "6"};
    LottoWin lottoWin = new LottoWin(lottowinningNumbers);
    lottoWin.addWinningLotto(lotto);

    assertThat(lottoWin.getFirstWinnerCount()).isEqualTo(1);
    assertThat(lottoWin.getSecondWinnerCount()).isEqualTo(0);
    assertThat(lottoWin.getThirdWinnerCount()).isEqualTo(0);
    assertThat(lottoWin.getFourthWinnerCount()).isEqualTo(0);
  }

  @Test
  public void Lotto_2등_추첨_테스트() {
    List lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    Lotto lotto = new Lotto(lottoNumber);

    String[] lottowinningNumbers = {"1", "2", "3", "4", "5", "16"};
    LottoWin lottoWin = new LottoWin(lottowinningNumbers);
    lottoWin.addWinningLotto(lotto);

    assertThat(lottoWin.getFirstWinnerCount()).isEqualTo(0);
    assertThat(lottoWin.getSecondWinnerCount()).isEqualTo(1);
    assertThat(lottoWin.getThirdWinnerCount()).isEqualTo(0);
    assertThat(lottoWin.getFourthWinnerCount()).isEqualTo(0);
  }

  @Test
  public void Lotto_3등_추첨_테스트() {
    List lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    Lotto lotto = new Lotto(lottoNumber);

    String[] lottowinningNumbers = {"1", "2", "3", "4", "15", "16"};
    LottoWin lottoWin = new LottoWin(lottowinningNumbers);
    lottoWin.addWinningLotto(lotto);

    assertThat(lottoWin.getFirstWinnerCount()).isEqualTo(0);
    assertThat(lottoWin.getSecondWinnerCount()).isEqualTo(0);
    assertThat(lottoWin.getThirdWinnerCount()).isEqualTo(1);
    assertThat(lottoWin.getFourthWinnerCount()).isEqualTo(0);
  }

  @Test
  public void Lotto_4등_추첨_테스트() {
    List lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    Lotto lotto = new Lotto(lottoNumber);

    String[] lottowinningNumbers = {"1", "2", "3", "14", "15", "16"};
    LottoWin lottoWin = new LottoWin(lottowinningNumbers);
    lottoWin.addWinningLotto(lotto);

    assertThat(lottoWin.getFirstWinnerCount()).isEqualTo(0);
    assertThat(lottoWin.getSecondWinnerCount()).isEqualTo(0);
    assertThat(lottoWin.getThirdWinnerCount()).isEqualTo(0);
    assertThat(lottoWin.getFourthWinnerCount()).isEqualTo(1);
  }

  @Test
  public void Lotto_미당첨_추첨_테스트() {
    List lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    Lotto lotto = new Lotto(lottoNumber);

    String[] lottowinningNumbers = {"11", "22", "33", "14", "15", "16"};
    LottoWin lottoWin = new LottoWin(lottowinningNumbers);
    lottoWin.addWinningLotto(lotto);

    assertThat(lottoWin.getFirstWinnerCount()).isEqualTo(0);
    assertThat(lottoWin.getSecondWinnerCount()).isEqualTo(0);
    assertThat(lottoWin.getThirdWinnerCount()).isEqualTo(0);
    assertThat(lottoWin.getFourthWinnerCount()).isEqualTo(0);
  }


  @Test
  public void Lotto_winner_count_test() {

    String[] lottowinningNumbers = {"1", "2", "3", "4", "5", "6"};
    LottoWin lottoWin = new LottoWin(lottowinningNumbers);

    lottoWin.countUpFirstWinner();
    lottoWin.countUpSecondWinner();
    lottoWin.countUpThirdWinner();
    lottoWin.countUpFourthWinner();

    assertThat(lottoWin.getFirstWinnerCount()).isEqualTo(1);
    assertThat(lottoWin.getSecondWinnerCount()).isEqualTo(1);
    assertThat(lottoWin.getThirdWinnerCount()).isEqualTo(1);
    assertThat(lottoWin.getFourthWinnerCount()).isEqualTo(1);
  }
}
