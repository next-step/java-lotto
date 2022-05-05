package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.strategy.ManualLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumbersTest {

  @ParameterizedTest
  @DisplayName("문자열 로또 번호들을 받아 잘 생성되는지 확인")
  @ValueSource(strings = {"1,5,10,11,12,13", "1,10,11,22,23,24", "1,10,13,33,34,35"})
  void generate(String numbers) {
    LottoNumbers lottoNumbers = LottoNumbers.from(numbers);

    assertThat(lottoNumbers).usingRecursiveComparison().isEqualTo(LottoNumbers.from(numbers));
  }

  @ParameterizedTest
  @DisplayName("숫자 로또 번호들을 받아 잘 생성되는지 확인")
  @ValueSource(strings = {"1,5,10,11,12,13", "1,10,11,22,23,24", "1,10,13,33,34,35"})
  void generator(String numbers) {
    List<Integer> intNumbers = Arrays.stream(numbers.split(","))
        .map(Integer::parseInt).
        collect(Collectors.toList());
    LottoNumbers lottoNumbers = LottoNumbers.from(intNumbers);

    assertThat(lottoNumbers).usingRecursiveComparison().isEqualTo(LottoNumbers.from(intNumbers));
  }

  @ParameterizedTest
  @DisplayName("매칭된 번호를 잘 가져오는지 확인")
  @CsvSource(value = {"1,5,10,13,14,15|1,20,25,26,27,28|1", "1,2,3,4,5,6|7,8,9,10,11,12|0",
      "1,10,13,22,23,24|1,10,13,43,44,45|3"}, delimiter = '|')
  void match(String numbers, String winNumbers, int matchCount) {
    LottoNumbers lottoNumbers = LottoNumbers.from(
        new ManualLottoNumberGenerator(numbers).generate());
    LottoNumbers winLottoNumbers = LottoNumbers.from(
        new ManualLottoNumberGenerator(winNumbers).generate());

    assertThat(lottoNumbers.getMatchNumbers(winLottoNumbers)).isEqualTo(matchCount);
  }
}