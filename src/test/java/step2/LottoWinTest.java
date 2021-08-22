package step2;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.model.Lotto;
import step2.model.LottoWin;
import step2.model.Lottos;
import step2.model.WinnerMoney;

public class LottoWinTest {


  List lottoNumber;

  @BeforeEach
  void setUp() {
    lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
  }

  @Test
  public void Lotto_1등_추첨_테스트() {

    Lottos lottos = new Lottos(Arrays.asList(new Lotto(lottoNumber)));
    String[] lottowinningNumbers = {"1", "2", "3", "4", "5", "6"};
    LottoWin lottoWin = new LottoWin(lottowinningNumbers);
    lottoWin.draw(lottos);

    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIRST_WINNER_MONEY.getWinRank())).isEqualTo(1);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.SECOND_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.THIRD_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FOURTH_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIFTH_WINNER_MONEY.getWinRank())).isEqualTo(0);
  }

  @Test
  public void Lotto_2등_추첨_테스트() {
    Lottos lottos = new Lottos(Arrays.asList(new Lotto(lottoNumber)));
    String[] lottowinningNumbers = {"1", "2", "3", "4", "5", "16"};
    LottoWin lottoWin = new LottoWin(lottowinningNumbers, 6);
    lottoWin.draw(lottos);

    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIRST_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.SECOND_WINNER_MONEY.getWinRank())).isEqualTo(1);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.THIRD_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FOURTH_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIFTH_WINNER_MONEY.getWinRank())).isEqualTo(0);
  }


  @Test
  public void Lotto_3등_추첨_테스트() {
    Lottos lottos = new Lottos(Arrays.asList(new Lotto(lottoNumber)));
    String[] lottowinningNumbers = {"1", "2", "3", "4", "5", "16"};
    LottoWin lottoWin = new LottoWin(lottowinningNumbers);
    lottoWin.draw(lottos);

    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIRST_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.SECOND_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.THIRD_WINNER_MONEY.getWinRank())).isEqualTo(1);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FOURTH_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIFTH_WINNER_MONEY.getWinRank())).isEqualTo(0);
  }

  @Test
  public void Lotto_4등_추첨_테스트() {
    Lottos lottos = new Lottos(Arrays.asList(new Lotto(lottoNumber)));
    String[] lottowinningNumbers = {"1", "2", "3", "4", "15", "16"};
    LottoWin lottoWin = new LottoWin(lottowinningNumbers);
    lottoWin.draw(lottos);

    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIRST_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.SECOND_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.THIRD_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FOURTH_WINNER_MONEY.getWinRank())).isEqualTo(1);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIFTH_WINNER_MONEY.getWinRank())).isEqualTo(0);
  }

  @Test
  public void Lotto_5등_추첨_테스트() {
    Lottos lottos = new Lottos(Arrays.asList(new Lotto(lottoNumber)));
    String[] lottowinningNumbers = {"1", "2", "3", "14", "15", "16"};
    LottoWin lottoWin = new LottoWin(lottowinningNumbers);
    lottoWin.draw(lottos);

    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIRST_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.SECOND_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.THIRD_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FOURTH_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIFTH_WINNER_MONEY.getWinRank())).isEqualTo(1);
  }

  @Test
  public void Lotto_미당첨_추첨_테스트() {
    Lottos lottos = new Lottos(Arrays.asList(new Lotto(lottoNumber)));
    String[] lottowinningNumbers = {"11", "22", "33", "14", "15", "16"};
    LottoWin lottoWin = new LottoWin(lottowinningNumbers);
    lottoWin.draw(lottos);

    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIRST_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.SECOND_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.THIRD_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FOURTH_WINNER_MONEY.getWinRank())).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIFTH_WINNER_MONEY.getWinRank())).isEqualTo(0);
  }


  @Test
  public void Lotto_winner_count_test() {
    String[] lottowinningNumbers = {"1", "2", "3", "4", "5", "6"};
    LottoWin lottoWin = new LottoWin(lottowinningNumbers);

    for(WinnerMoney winnerMoney : WinnerMoney.values()) {
      lottoWin.addWinnerCount(winnerMoney, winnerMoney.hasMatchBonusNumber());
    }

    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIRST_WINNER_MONEY.getWinRank())).isEqualTo(1);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.SECOND_WINNER_MONEY.getWinRank())).isEqualTo(1);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.THIRD_WINNER_MONEY.getWinRank())).isEqualTo(1);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FOURTH_WINNER_MONEY.getWinRank())).isEqualTo(1);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIFTH_WINNER_MONEY.getWinRank())).isEqualTo(1);
  }
}
