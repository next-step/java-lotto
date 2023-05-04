package study.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lottogame.util.LottoNumbersGenerator;

public class LotteryTest {

  @DisplayName("로또번호가 6자리가 아니라면 Exception을 던진다.")
  @Test
  public void Lottery_throwException_sizeNotEqual6(){
    List<LottoNumber> lottoNumbers = LottoNumbersGenerator
        .generate(new String[]{"1", "2", "3", "4", "5"});
    assertThatThrownBy(()->new Lottery(Set.copyOf(lottoNumbers))).isInstanceOf(IllegalArgumentException.class);

    List<LottoNumber> lottoNumbers2 = LottoNumbersGenerator
        .generate(new String[]{"1", "2", "3", "4", "5", "6", "7"});
    assertThatThrownBy(()->new Lottery(Set.copyOf(lottoNumbers2))).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("중복되는 로또번호가 들어간다면 Exception을 던진다.")
  @Test
  public void Lottery_throwException_duplicatedNumber(){
    List<LottoNumber> lottoNumbers = LottoNumbersGenerator
        .generate(new String[]{"1", "1", "2", "3", "4", "5"});
    assertThatThrownBy(()->new Lottery(Set.copyOf(lottoNumbers))).isInstanceOf(IllegalArgumentException.class);

    List<LottoNumber> lottoNumbers2 = LottoNumbersGenerator
        .generate(new String[]{"1", "2", "3", "4", "10", "10"});
    assertThatThrownBy(()->new Lottery(Set.copyOf(lottoNumbers2))).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("주어진 로또번호들 몇개의 번호가 동일한지 반환한다.")
  @Test
  public void int_matchLottoNumbers_equalLottoNumberCount(){
    List<LottoNumber> lottoNumbers = LottoNumbersGenerator
        .generate(new String[]{"1", "2", "3", "4", "5", "6"});
    Lottery lottery = new Lottery(Set.copyOf(lottoNumbers));

    List<LottoNumber> otherLottoNumbers = LottoNumbersGenerator
        .generate(new String[]{"3", "4", "5", "6", "7", "8"});
    Lottery otherLottery = new Lottery(Set.copyOf(otherLottoNumbers));

    assertThat(lottery.matchLottoNumbers(otherLottery)).isEqualTo(4);
  }

  @DisplayName("주어진 로또번호를 포함하고있는지 여부를 반환한다.")
  @Test
  public void boolean_matchLottoNumber_containsLottoNumber(){
    List<LottoNumber> lottoNumbers = LottoNumbersGenerator
        .generate(new String[]{"1", "2", "3", "4", "5", "6"});
    Lottery lottery = new Lottery(Set.copyOf(lottoNumbers));

    LottoNumber lottoNumber = LottoNumber.valueOf(1);

    assertThat(lottery.matchLottoNumber(lottoNumber)).isTrue();

  }

}
