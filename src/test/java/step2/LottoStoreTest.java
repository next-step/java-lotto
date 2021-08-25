package step2;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.model.Lotto.LottoNo;
import step2.model.Lotto.LottoNos;
import step2.model.Lotto.Lottos;
import step2.model.LottoStore.LottoStore;
import step2.model.LottoStore.LottoWin;
import step2.model.LottoStore.WinnerMoney;
import step2.model.view.Input;

public class LottoStoreTest {

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
  public void Lotto_1개_구매_테스트() {
    int userAmount = 1000;
    int userManualLottoCount = 0;

    List<LottoNos> lottoNosList = new ArrayList();
    lottoNosList.add(new LottoNos(lottoNoList));

    Input input = new Input(userAmount, userManualLottoCount, lottoNosList);

    LottoStore lottoStore = new LottoStore();
    Lottos lottos = lottoStore.purchase(input);

    for (int i = 0; i < lottos.getLottosSize(); i++) {
      assertThat(lottos.getLotto(i).getLottoNos())
          .isEqualToComparingFieldByField(lottoNosList.get(i));
    }
  }


  @ParameterizedTest
  @ValueSource(ints = {2, 3, 14})
  public void Lotto_N개_구매_테스트(int userManualLottoCount) {

    int userAmount = userManualLottoCount * 1000;

    List<LottoNos> lottoNosList = new ArrayList();
    for (int i = 0; i < userManualLottoCount; i++) {
      lottoNosList.add(getLottoNoList(i));
    }

    Input input = new Input(userAmount, userManualLottoCount, lottoNosList);

    LottoStore lottoStore = new LottoStore();
    Lottos lottos = lottoStore.purchase(input);

    for (int i = 0; i < lottos.getLottosSize(); i++) {
      assertThat(lottos.getLotto(i).getLottoNos())
          .isEqualToComparingFieldByField(lottoNosList.get(i));
    }
  }

  LottoNos getLottoNoList(int i) {

    List<LottoNo> lottoNoList = new ArrayList<>();
    for (int j = 0; j < 6; j++) {
      lottoNoList.add(new LottoNo(i + j));
    }

    return new LottoNos(lottoNoList);
  }


  @ParameterizedTest
  @ValueSource(strings = {"1,2,3,4,5,6"})
  public void Lotto_추첨_후_당첨자_확인(String lottowinningNumbers) {
    int userAmount = 1000;
    int lottoBonusNumber = 7;
    int userManualLottoCount = 0;

    List<LottoNos> lottoNosList = new ArrayList();
    lottoNosList.add(new LottoNos(lottoNoList));
    Input input = new Input(userAmount, userManualLottoCount, lottoNosList);

    LottoStore lottoStore = new LottoStore();
    Lottos lottos = lottoStore.purchase(input);

    input.setLottowinningBonusNumbers(lottoBonusNumber);
    input.setLottowinningNumbers(lottowinningNumbers.split(","));

    LottoWin lottoWin = lottoStore.draw(lottos, input);

    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIRST_WINNER_MONEY)).isEqualTo(1);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.SECOND_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.THIRD_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FOURTH_WINNER_MONEY)).isEqualTo(0);
    assertThat(lottoWin.getWinnerCount(WinnerMoney.FIFTH_WINNER_MONEY)).isEqualTo(0);
  }

  @Test
  void Lotto_3장_수동_구입() {
    int userManualLottoCount = 3;
    int userAmount = userManualLottoCount * 1000;

    List<LottoNos> lottoNosList = new ArrayList();
    for (int i = 0; i < userManualLottoCount; i++) {
      lottoNosList.add(getLottoNoList(i));
    }

    Input input = new Input(userAmount, userManualLottoCount, lottoNosList);

    LottoStore lottoStore = new LottoStore();
    Lottos lottos = lottoStore.purchase(input);

    for (int i = 0; i < lottos.getLottosSize(); i++) {
      assertThat(lottos.getLotto(i).getLottoNos()).isEqualTo(lottoNosList.get(i));
    }
  }
}
