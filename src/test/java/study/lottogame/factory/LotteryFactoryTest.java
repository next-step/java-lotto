package study.lottogame.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lottogame.domain.Lottery;
import study.lottogame.domain.LottoNumber;
import study.lottogame.util.LottoNumbersGenerator;

public class LotteryFactoryTest {

  @DisplayName("자동 로또를 생성한다.")
  @Test
  public void create_AutoNumber() {
    Lottery lottery = LotteryFactory.create();

    assertThat(lottery.getLottoNumbers()).hasSize(Lottery.LOTTO_NUMBER_COUNT);
  }

  @DisplayName("수동 로또를 생성한다.")
  @Test
  public void create_ManualNumber() {
    List<LottoNumber> lottoNumbers = LottoNumbersGenerator
        .generate(new String[]{"1", "2", "3", "4", "5", "6"});

    Lottery lottery = LotteryFactory.create(lottoNumbers);

    assertThat(lottery.getLottoNumbers()).hasSize(Lottery.LOTTO_NUMBER_COUNT);
    assertThat(lottery.getLottoNumbers())
        .containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
  }

  @DisplayName("6자리가 아닌 로또는 생성할 수 없다.")
  @Test
  public void create_throwException_sizeNotEqual6() {
    List<LottoNumber> lottoNumbers1 = LottoNumbersGenerator
        .generate(new String[]{"1", "2", "3", "4", "5"});
    assertThatThrownBy(() -> LotteryFactory.create(lottoNumbers1))
        .isInstanceOf(IllegalArgumentException.class);

    List<LottoNumber> lottoNumbers2 = LottoNumbersGenerator
        .generate(new String[]{"1", "2", "3", "4", "5", "6", "7"});
    assertThatThrownBy(() -> LotteryFactory.create(lottoNumbers2))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("중복되는 로또번호가 들어가는 로또는 생성할 수 없다.")
  @Test
  public void create_throwException_duplicatedNumber() {
    List<LottoNumber> lottoNumbers1 = LottoNumbersGenerator
        .generate(new String[]{"1", "1", "2", "3", "4", "5"});
    assertThatThrownBy(() -> LotteryFactory.create(lottoNumbers1))
        .isInstanceOf(IllegalArgumentException.class);

    List<LottoNumber> lottoNumbers2 = LottoNumbersGenerator
        .generate(new String[]{"1", "2", "3", "4", "10", "10"});
    assertThatThrownBy(() -> LotteryFactory.create(lottoNumbers2))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
