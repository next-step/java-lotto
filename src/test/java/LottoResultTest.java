import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.Lotto;
import lotto.LottoMachine;
import lotto.LottoNumber;
import lotto.LottoResult;
import lotto.LottoResultType;
import lotto.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

  private Lottos lottos;
  private Lotto resultLotto;
  @BeforeEach
  void setting_lotto() {

    List<LottoNumber> threeMatchLottoNumbers = List.of(
        LottoNumber.of(5), LottoNumber.of(25)
        , LottoNumber.of(30), LottoNumber.of(8)
        , LottoNumber.of(2), LottoNumber.of(43)
    );
    List<LottoNumber> threeMatchLottoNumbers2 = List.of(
        LottoNumber.of(5), LottoNumber.of(25)
        , LottoNumber.of(30), LottoNumber.of(8)
        , LottoNumber.of(2), LottoNumber.of(43)
    );
    Lotto threeMatchLotto = Lotto.defaultOf(threeMatchLottoNumbers);
    Lotto threeMatchLotto2 = Lotto.defaultOf(threeMatchLottoNumbers2);

    List<LottoNumber> fourMatchLottoNumbers = List.of(
        LottoNumber.of(5), LottoNumber.of(25)
        , LottoNumber.of(30), LottoNumber.of(8)
        , LottoNumber.of(2), LottoNumber.of(40)
    );
    Lotto fourMatchLotto = Lotto.defaultOf(fourMatchLottoNumbers);
    lottos = Lottos.of(List.of(threeMatchLotto,threeMatchLotto2, fourMatchLotto));

    List<LottoNumber> lottoResultNumbers = List.of(
        LottoNumber.of(5), LottoNumber.of(25)
        , LottoNumber.of(30), LottoNumber.of(6)
        , LottoNumber.of(1), LottoNumber.of(40)
    );
    resultLotto = Lotto.defaultOf(lottoResultNumbers);
  }

  @Test
  @DisplayName("Lotto중에 매칭 개수되는 Lotto들 카운팅하기")
  public void count_matching() {
    // given
    LottoResult lottoResult = LottoMachine.match(resultLotto, lottos);

    // when
    int result = lottoResult.findMatchResultCount(LottoResultType.THREE);

    // then
    assertThat(result).isEqualTo(2);
  }

  @Test
  @DisplayName("수익률 계산 기능")
  public void caculate_profit_rate() throws Exception {
    // given
    int amount = resultLotto.size() * 1000;
    LottoResult result = LottoMachine.match(resultLotto, lottos);

    // when
    double profitRate = result.calculateProfitRate(amount);

    // then
    Assertions.assertThat(profitRate).isEqualTo(10.0);
  }
}
