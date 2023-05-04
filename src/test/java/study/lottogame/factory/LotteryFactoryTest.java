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
    Lottery lottery = LotteryFactory.create(new String[]{"1", "2", "3", "4", "5", "6"});

    assertThat(lottery.getLottoNumbers()).hasSize(Lottery.LOTTO_NUMBER_COUNT);
    assertThat(lottery.getLottoNumbers()).contains(LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3),
            LottoNumber.valueOf(4), LottoNumber.valueOf(5), LottoNumber.valueOf(6));
  }

  @DisplayName("6자리가 아닌 로또는 생성할 수 없다.")
  @Test
  public void create_throwException_sizeNotEqual6() {
    assertThatThrownBy(() -> LotteryFactory.create(new String[]{"1", "2", "3", "4", "5"}))
        .isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() -> LotteryFactory.create(new String[]{"1", "2", "3", "4", "5", "6", "7"}))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("중복되는 로또번호가 들어가는 로또는 생성할 수 없다.")
  @Test
  public void create_throwException_duplicatedNumber() {
    assertThatThrownBy(() -> LotteryFactory.create(new String[]{"1", "1", "2", "3", "4", "5"}))
        .isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() -> LotteryFactory.create(new String[]{"1", "2", "3", "4", "10", "10"}))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
