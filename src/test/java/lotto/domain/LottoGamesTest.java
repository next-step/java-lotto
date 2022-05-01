package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.strategy.FixedNumberGenerator;
import lotto.domain.strategy.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGamesTest {

  @ParameterizedTest
  @DisplayName("로또 게임이 잘 생성되는지 확인")
  @CsvSource(value = {"1,5,10,15,20,2|50|1", "5,11,18,20,35,45|20|1",
      "1,9,12,26,35,38|40|0"}, delimiter = '|')
  void generate(String numbers, int gameCount) {
    List<NumberGenerator> numberGenerators = new ArrayList<>();
    List<NumberGenerator> expectGenerators = new ArrayList<>();
    for (int i = 0; i < gameCount; i++) {
      numberGenerators.add(new FixedNumberGenerator(numbers));
      expectGenerators.add(new FixedNumberGenerator(numbers));
    }
    LottoGames lottoGames = new LottoGames(gameCount, numberGenerators);

    assertThat(lottoGames).usingRecursiveComparison()
        .isEqualTo(new LottoGames(gameCount, expectGenerators));
  }

  @ParameterizedTest
  @DisplayName("로또 추첨 결과 잘 가져오는지 확인")
  @CsvSource(value = {"4,8,19,23,11,7|1,5,10,15,20,2|50|0",
      "5,11,16,20,35,40|5,11,18,20,35,45|20|4",
      "1,9,12,26,35,38|1,9,12,26,35,38|1|6"}, delimiter = '|')
  void draw(String lottoNumbers, String winNumbers, int gameCount, int matchCount) {
    List<NumberGenerator> numberGenerators = new ArrayList<>();
    for (int i = 0; i < gameCount; i++) {
      numberGenerators.add(new FixedNumberGenerator(lottoNumbers));
    }
    LottoGames lottoGames = new LottoGames(gameCount, numberGenerators);
    LottoNumbers winLottoNumbers = new LottoNumbers(winNumbers);

    LottoDrawResults lottoDrawResults = lottoGames.draw(winLottoNumbers, null);

    assertThat(lottoDrawResults.getRewordAll()).isEqualTo(
        LottoReword.getWinMoney(matchCount, false) * gameCount);
  }

  @ParameterizedTest
  @DisplayName("보너스 번호가 포함된 로또 추첨 결과 잘 가져오는지 확인")
  @CsvSource(value = {"4,8,19,23,11,7|1,5,10,15,20,2|4|50|0",
      "5,11,16,20,35,40|5,11,16,20,35,45|45|20|5",
      "1,9,12,26,35,38|1,9,12,26,35,38|40|1|6"}, delimiter = '|')
  void drawWithBonus(String lottoNumbers, String winNumbers, String bonusNumber, int gameCount,
      int matchCount) {
    List<NumberGenerator> numberGenerators = new ArrayList<>();
    for (int i = 0; i < gameCount; i++) {
      numberGenerators.add(new FixedNumberGenerator(lottoNumbers));
    }
    LottoGames lottoGames = new LottoGames(gameCount, numberGenerators);
    LottoNumbers winLottoNumbers = new LottoNumbers(winNumbers);

    LottoDrawResults lottoDrawResults = lottoGames
        .draw(winLottoNumbers, new LottoNumber(bonusNumber));

    assertThat(lottoDrawResults.getRewordAll()).isEqualTo(
        LottoReword.getWinMoney(matchCount, true) * gameCount);
  }
}