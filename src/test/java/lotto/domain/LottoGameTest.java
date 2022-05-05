package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameTest {

  @ParameterizedTest
  @DisplayName("로또 게임이 잘 생성되는지 확인")
  @ValueSource(strings = {"1,5,10,15,20,2", "5,11,18,20,35,45", "1,9,12,26,35,38"})
  void generate(String numbers) {
    LottoGame lottoGame = LottoGame.from(numbers);

    assertThat(lottoGame).usingRecursiveComparison().isEqualTo(LottoGame.from(numbers));
  }

  @ParameterizedTest
  @DisplayName("로또 추첨 결과 잘 가져오는지 확인")
  @CsvSource(value = {"1,5,10,15,20,2|1,2,10,40,44,45|FIFTH",
      "5,11,18,20,35,45|5,11,18,20,35,45|FIRST",
      "1,9,12,26,35,38|38,35,11,12,9,1|THIRD"}, delimiter = '|')
  void draw(String winNumbers, String lottoNumbers, LottoReword rewordExpect) {
    LottoGame lottoGame = LottoGame.from(lottoNumbers);
    LottoReword lottoReword = lottoGame.draw(LottoNumbers.from(winNumbers), null);

    assertThat(lottoReword).isEqualTo(rewordExpect);
  }

  @ParameterizedTest
  @DisplayName("보너스 번호가 포함된 로또 추첨 결과 잘 가져오는지 확인")
  @CsvSource(value = {"1,5,10,15,20,2|1,2,10,40,44,45|20|FIFTH",
      "5,11,18,20,35,45|5,11,18,20,35,45|44|FIRST",
      "1,9,12,26,35,38|38,35,11,12,9,1|26|SECOND"}, delimiter = '|')
  void draw(String winNumbers, String lottoNumbers, int bonusNumber, LottoReword rewordExpect) {
    LottoGame lottoGame = LottoGame.from(lottoNumbers);
    LottoReword lottoReword = lottoGame
        .draw(LottoNumbers.from(winNumbers), LottoNumber.from(bonusNumber));

    assertThat(lottoReword).isEqualTo(rewordExpect);
  }
}