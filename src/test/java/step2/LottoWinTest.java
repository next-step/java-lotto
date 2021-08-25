package step2;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.model.Lotto.Lotto;
import step2.model.Lotto.LottoNo;
import step2.model.Lotto.LottoNos;
import step2.model.Lotto.Lottos;
import step2.model.LottoStore.LottoWin;
import step2.model.LottoStore.WinnerMoney;

public class LottoWinTest {

  List<LottoNo> lottoNoList;

  @BeforeEach
  void setUp() {
    lottoNoList = new ArrayList<>();
    int[] lottoNos = {1, 2, 3, 4, 5, 6};

    for (int i = 0; i < lottoNos.length; i++) {
      lottoNoList.add(new LottoNo(lottoNos[i]));
    }
  }


  @Test
  public void Lotto_1등_추첨_테스트() {
    LottoNos lottoNos = new LottoNos(lottoNoList);
    Lottos lottos = new Lottos(Arrays.asList(new Lotto(lottoNos)));
    String[] lottowinningNumbers = {"1", "2", "3", "4", "5", "6"};
    int bonusNumber = 10;
    LottoWin lottoWin = new LottoWin(lottowinningNumbers, bonusNumber);
    lottoWin.draw(lottos);

    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIRST_WINNER_MONEY)).isEqualTo(1);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.SECOND_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.THIRD_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FOURTH_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIFTH_WINNER_MONEY)).isEqualTo(0);
  }

  @Test
  public void Lotto_2등_추첨_테스트() {
    LottoNos lottoNos = new LottoNos(lottoNoList);
    Lottos lottos = new Lottos(Arrays.asList(new Lotto(lottoNos)));
    String[] lottowinningNumbers = {"1", "2", "3", "4", "5", "16"};
    int bonusNumber = 6;
    LottoWin lottoWin = new LottoWin(lottowinningNumbers, bonusNumber);
    lottoWin.draw(lottos);

    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIRST_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.SECOND_WINNER_MONEY)).isEqualTo(1);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.THIRD_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FOURTH_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIFTH_WINNER_MONEY)).isEqualTo(0);
  }


  @Test
  public void Lotto_3등_추첨_테스트() {
    LottoNos lottoNos = new LottoNos(lottoNoList);
    Lottos lottos = new Lottos(Arrays.asList(new Lotto(lottoNos)));
    String[] lottowinningNumbers = {"1", "2", "3", "4", "5", "16"};
    int bonusNumber = 10;
    LottoWin lottoWin = new LottoWin(lottowinningNumbers, bonusNumber);
    lottoWin.draw(lottos);

    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIRST_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.SECOND_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.THIRD_WINNER_MONEY)).isEqualTo(1);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FOURTH_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIFTH_WINNER_MONEY)).isEqualTo(0);
  }

  @Test
  public void Lotto_4등_추첨_테스트() {
    LottoNos lottoNos = new LottoNos(lottoNoList);
    Lottos lottos = new Lottos(Arrays.asList(new Lotto(lottoNos)));
    String[] lottowinningNumbers = {"1", "2", "3", "4", "15", "16"};
    int bonusNumber = 10;
    LottoWin lottoWin = new LottoWin(lottowinningNumbers, bonusNumber);
    lottoWin.draw(lottos);

    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIRST_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.SECOND_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.THIRD_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FOURTH_WINNER_MONEY)).isEqualTo(1);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIFTH_WINNER_MONEY)).isEqualTo(0);
  }

  @Test
  public void Lotto_5등_추첨_테스트() {
    LottoNos lottoNos = new LottoNos(lottoNoList);
    Lottos lottos = new Lottos(Arrays.asList(new Lotto(lottoNos)));
    String[] lottowinningNumbers = {"1", "2", "3", "14", "15", "16"};
    int bonusNumber = 10;
    LottoWin lottoWin = new LottoWin(lottowinningNumbers, bonusNumber);
    lottoWin.draw(lottos);

    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIRST_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.SECOND_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.THIRD_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FOURTH_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIFTH_WINNER_MONEY)).isEqualTo(1);
  }

  @Test
  public void Lotto_미당첨_추첨_테스트() {
    LottoNos lottoNos = new LottoNos(lottoNoList);
    Lottos lottos = new Lottos(Arrays.asList(new Lotto(lottoNos)));
    String[] lottowinningNumbers = {"11", "22", "33", "14", "15", "16"};
    int bonusNumber = 10;
    LottoWin lottoWin = new LottoWin(lottowinningNumbers, bonusNumber);
    lottoWin.draw(lottos);

    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIRST_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.SECOND_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.THIRD_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FOURTH_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIFTH_WINNER_MONEY)).isEqualTo(0);
  }
}
