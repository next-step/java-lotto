package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.strategy.FixedNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumbersTest {

  @ParameterizedTest
  @DisplayName("로또 번호들을 받아 잘 생성되는지 확인")
  @ValueSource(strings = {"1,5,10", "20,40,41", "1,1,1", "3,1,45"})
  void generate(String numbers) {
    LottoNumbers lottoNumbers = new LottoNumbers(numbers);

    assertThat(lottoNumbers).usingRecursiveComparison().isEqualTo(new LottoNumbers(numbers));
  }

  @ParameterizedTest
  @DisplayName("번호 생성 클래스를 받아 잘 생성되는지 확인")
  @ValueSource(ints = {1, 5, 10, 45})
  void generate(int fixValue) {
    LottoNumbers lottoNumbers = new LottoNumbers(6, new FixedNumberGenerator(fixValue));

    assertThat(lottoNumbers).usingRecursiveComparison()
        .isEqualTo(new LottoNumbers(6, new FixedNumberGenerator(fixValue)));
  }

  @ParameterizedTest
  @DisplayName("매칭된 번호를 잘 가져오는지 확인")
  @ValueSource(ints = {1, 10, 15, 20, 45})
  void match() {
    LottoNumbers lottoNumbers = new LottoNumbers(6, new FixedNumberGenerator(5));
    LottoNumbers winNumbers = new LottoNumbers(6, new FixedNumberGenerator(5));

    assertThat(lottoNumbers.getMatchNumbers(winNumbers)).usingRecursiveComparison()
        .isEqualTo(lottoNumbers);
  }
}