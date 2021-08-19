package step2;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.model.Lotto;
import step2.model.LottoWin;
import step2.model.LottoWins;
import step2.model.Lottos;

public class LottoWinsTest {

  @ParameterizedTest
  @ValueSource(strings = {"1,2,3,4,5,6"})
  public void Lotto_추첨_후_당첨자_확인(String lottoNumStr) {
    String[] lottoNumStrs = lottoNumStr.split(",");
    List lottoNumber = Arrays.asList(lottoNumStrs);
    Lotto lotto = new Lotto(lottoNumber);
    Lottos lottos = new Lottos(Arrays.asList(lotto));

    String[] lottowinningNumbers = {"1", "2", "3", "4", "5", "6"};
    LottoWins lottoWins = new LottoWins(lottowinningNumbers);
    lottoWins.drawLotto(lottos);

    LottoWin lottoWin = lottoWins.getLottoWin(lottos);
    assertThat(lottoWin.getFirstWinnerCount()).isEqualTo(1);
  }
}
