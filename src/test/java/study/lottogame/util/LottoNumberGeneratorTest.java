package study.lottogame.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lottogame.domain.LottoNumber;

public class LottoNumberGeneratorTest {

  @DisplayName("로또 번호들을 자동으로 생성한다.")
  @Test
  public void generate() {
    List<LottoNumber> lottoNumbers = LottoNumbersGenerator.generate();

    assertThat(lottoNumbers).hasSize(6);
  }

  @DisplayName("로또 번호 수동 생성 시 null이거나 빈 공백문자가 포함되어 있을 경우 Exception이 발생한다.")
  @Test
  public void generate_throwException_nullOrEmpty() {
    String[] numbers = {null, "2", "3", "4", "5", "6"};
    assertThatThrownBy(() -> LottoNumbersGenerator.generate(numbers))
        .isInstanceOf(IllegalArgumentException.class);

    String[] numbers2 = {"", "2", "3", "4", "5", "6"};
    assertThatThrownBy(() -> LottoNumbersGenerator.generate(numbers2))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("로또 번호 수동 생성 시 1 ~ 45 범위를 넘어가는 경우 Exception이 발생한다.")
  @Test
  public void generate_throwException_outOfBound() {
    assertThatThrownBy(
        () -> LottoNumbersGenerator.generate(new String[]{"-1", "2", "3", "4", "5", "6"}))
        .isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(
        () -> LottoNumbersGenerator.generate(new String[]{"46", "2", "3", "4", "5", "6"}))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
