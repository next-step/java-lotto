package lotto.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RealGenerateLottoNumberTest {

  GenerateLottoNumber generateLottoNumber = new RealGenerateLottoNumber();

  @DisplayName("1~45까지 로또번호 생성 테스트.")
  @Test
  void 로또번호리스트생성() {


    assertThat(generateLottoNumber.createNumberPull().size()).isEqualTo(45);
  }

  @DisplayName("로또번호생성 최대값 확인 테스트.")
  @Test
  void 최대값체크테스트() {

    Integer maxValue = generateLottoNumber.createNumberPull().stream()
        .mapToInt(number -> number)
        .max()
        .orElseThrow(NoSuchElementException::new);

    assertThat(maxValue).isEqualTo(45);
  }

  @DisplayName("로또번호생성 최소값 확인 테스트.")
  @Test
  void 최소값체크테스트() {

    Integer minValue = generateLottoNumber.createNumberPull().stream()
        .mapToInt(number -> number)
        .min()
        .orElseThrow(NoSuchElementException::new);

    assertThat(minValue).isEqualTo(1);
  }
}