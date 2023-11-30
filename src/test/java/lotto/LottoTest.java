package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.LottoStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {

  @ParameterizedTest
  @ValueSource(ints = {46, 0})
  public void 로또_번호_발급_제한(int target) {
    Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(target));
  }

  @Test
  @DisplayName("로또 한장 발급 기능")
  public void lotto_print_only_one() {
    // given
    Lotto lotto = LottoMachine.one();
    // then
    assertThat(lotto.size()).isEqualTo(6);
  }

  @Test
  @DisplayName("로또 6개 생성")
  public void make_lottos() {
    int size = 6;

    Lottos lottos = LottoMachine.make(size);

    assertThat(lottos.sameSize(6)).isTrue();
  }


  @Test
  @DisplayName("금액대로 로또 사기")
  public void make_lotto_with_price() {
    int amount = 14000;
    LottoStore lottoStore = new LottoStore();

    Lottos lottos = lottoStore.sell(amount);

    assertThat(lottos.sameSize(14)).isTrue();
  }

  @Test
  @DisplayName("lotto.domain.LottoNumber equals 테스트")
  void lotto_number_equals() {
    // given
    LottoNumber lottoResultNumber1 = LottoNumber.of(5);
    LottoNumber lottoResultNumber2 = LottoNumber.of(5);
    // when
    boolean result = lottoResultNumber1.equals(lottoResultNumber2);

    // then
    assertThat(result).isTrue();

  }

  @Test
  @DisplayName("로또 매칭 개수 카운트 기능")
  public void matching_count() {
    // given
    LottoNumber lottoResultNumber1 = LottoNumber.of(5);
    LottoNumber lottoResultNumber2 = LottoNumber.of(25);
    LottoNumber lottoResultNumber3 = LottoNumber.of(30);
    LottoNumber lottoResultNumber4 = LottoNumber.of(6);
    LottoNumber lottoResultNumber5 = LottoNumber.of(1);
    LottoNumber lottoResultNumber6 = LottoNumber.of(40);
    List<LottoNumber> lottoResultNumbers = List.of(lottoResultNumber1, lottoResultNumber2,
        lottoResultNumber3, lottoResultNumber4, lottoResultNumber5, lottoResultNumber6);
    Lotto resultLotto = Lotto.defaultOf(lottoResultNumbers);

    LottoNumber lottoNumber1 = LottoNumber.of(5);
    LottoNumber lottoNumber2 = LottoNumber.of(25);
    LottoNumber lottoNumber3 = LottoNumber.of(31);
    LottoNumber lottoNumber4 = LottoNumber.of(8);
    LottoNumber lottoNumber5 = LottoNumber.of(2);
    LottoNumber lottoNumber6 = LottoNumber.of(43);
    List<LottoNumber> lottoNumbers = List.of(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4,
        lottoNumber5, lottoNumber6);
    Lotto lotto = Lotto.defaultOf(lottoNumbers);

    // when
    int result = resultLotto.howManySameNumber(lotto);

    // then
    assertThat(result).isEqualTo(2);
  }

}
