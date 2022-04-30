package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.strategy.FixedNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
  @ValueSource(strings = {"1,5,10", "1,10", "1,10,13"})
  void generator(String numbers) {
    LottoNumbers lottoNumbers = new LottoNumbers(new FixedNumberGenerator(numbers));

    assertThat(lottoNumbers).usingRecursiveComparison()
        .isEqualTo(new LottoNumbers(new FixedNumberGenerator(numbers)));
  }

  @ParameterizedTest
  @DisplayName("매칭된 번호를 잘 가져오는지 확인")
  @CsvSource(value = {"1,5,10|1,20,25|1", "1,10|2,20|0", "1,10,13|1,10,13|3"}, delimiter = '|')
  void match(String numbers, String winNumbers, int matchCount) {
    LottoNumbers lottoNumbers = new LottoNumbers(new FixedNumberGenerator(numbers));
    LottoNumbers winLottoNumbers = new LottoNumbers(new FixedNumberGenerator(winNumbers));

    assertThat(lottoNumbers.getMatchNumbers(winLottoNumbers).getNumberSize()).isEqualTo(matchCount);
  }
}