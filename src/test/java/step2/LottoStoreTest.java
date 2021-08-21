package step2;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.model.LottoStore;
import step2.model.LottoWin;
import step2.model.Lottos;

public class LottoStoreTest {


  @Test
  public void Lotto_1개_구매_테스트() {
    final int userAmount = 1000;

    List lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

    LottoStore lottoStore = new LottoStore();
    Lottos lottos = lottoStore.purchase(userAmount, lottoNumber);

    for (int i = 0; i < lottos.getLottosSize(); i++) {
      assertThat(lottos.getLotto(i).getLottoNumbers()).isEqualTo(lottoNumber);
    }
  }

  @ParameterizedTest
  @ValueSource(ints = {2000, 3000, 14000})
  public void Lotto_N개_구매_테스트(int userAmount) {
    List lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

    LottoStore lottoStore = new LottoStore();
    Lottos lottos = lottoStore.purchase(userAmount, lottoNumber);

    for (int i = 0; i < lottos.getLottosSize(); i++) {
      assertThat(lottos.getLotto(i).getLottoNumbers()).isEqualTo(lottoNumber);
    }
  }


  @ParameterizedTest
  @ValueSource(strings = {"1,2,3,4,5,6"})
  public void Lotto_추첨_후_당첨자_확인(String lottowinningNumbers) {
    int userAmount = 1000;
    List lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

    LottoStore lottoStore = new LottoStore();
    Lottos lottos = lottoStore.purchase(userAmount, lottoNumber);

    LottoWin lottoWin = lottoStore.draw(lottos, lottowinningNumbers.split(","));

    assertThat(lottoWin.getFirstWinnerCount()).isEqualTo(1);
    assertThat(lottoWin.getSecondWinnerCount()).isEqualTo(0);
    assertThat(lottoWin.getThirdWinnerCount()).isEqualTo(0);
    assertThat(lottoWin.getFourthWinnerCount()).isEqualTo(0);
  }
}
