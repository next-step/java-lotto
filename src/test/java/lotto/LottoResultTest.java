package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.enums.LottoResultType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

  private Lottos lottos;
  private Lotto resultLotto;
  @BeforeEach
  void setting_lotto() {

    Set<LottoNumber> threeMatchLottoNumbers =  new HashSet<>(List.of(
        LottoNumber.of(5), LottoNumber.of(25)
        , LottoNumber.of(30), LottoNumber.of(8)
        , LottoNumber.of(2), LottoNumber.of(43)
    ));
    Set<LottoNumber> threeMatchLottoNumbers2 =  new HashSet<>(List.of(
        LottoNumber.of(5), LottoNumber.of(25)
        , LottoNumber.of(30), LottoNumber.of(8)
        , LottoNumber.of(2), LottoNumber.of(43)
    ));
    Lotto threeMatchLotto = Lotto.defaultOf(threeMatchLottoNumbers);
    Lotto threeMatchLotto2 = Lotto.defaultOf(threeMatchLottoNumbers2);

    Set<LottoNumber> fourMatchLottoNumbers = new HashSet<>(List.of(
        LottoNumber.of(5), LottoNumber.of(25)
        , LottoNumber.of(30), LottoNumber.of(8)
        , LottoNumber.of(2), LottoNumber.of(40)
    ));
    Lotto fourMatchLotto = Lotto.defaultOf(fourMatchLottoNumbers);
    lottos = Lottos.of(List.of(threeMatchLotto,threeMatchLotto2, fourMatchLotto));

    Set<LottoNumber> lottoResultNumbers =  new HashSet<>(List.of(
        LottoNumber.of(5), LottoNumber.of(25)
        , LottoNumber.of(30), LottoNumber.of(6)
        , LottoNumber.of(1), LottoNumber.of(40)
    ));
    resultLotto = Lotto.defaultOf(lottoResultNumbers);
  }

  @Test
  @DisplayName("Lotto중에 매칭 개수되는 Lotto들 카운팅하기")
  public void count_matching() {
    // given
    LottoResult lottoResult = LottoMachine.matchWithBonusNumber(resultLotto, lottos, null);

    // when
    int result = lottoResult.findMatchResultCount(LottoResultType.THREE);

    // then
    assertThat(result).isEqualTo(2);
  }

  @Test
  @DisplayName("Lotto중에 매칭 개수되는 Lotto들 카운팅하기")
  public void bonus_number_matching() {
    // given
    LottoResult lottoResult = LottoMachine.matchWithBonusNumber(resultLotto, lottos,null);

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
    LottoResult result = LottoMachine.matchWithBonusNumber(resultLotto, lottos, null);

    // when
    double profitRate = result.calculateProfitRate(amount);

    // then
    Assertions.assertThat(profitRate).isEqualTo(10.0);
  }
}
