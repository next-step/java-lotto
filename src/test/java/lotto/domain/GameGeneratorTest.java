package lotto.domain;

import lotto.domain.strategy.TestRandomNumberGenerateStrategy;
import lotto.dto.OrderSheet;
import lotto.util.TestUtil;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.util.TestUtil.getOneToSixLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class GameGeneratorTest {

  private GameGenerator oneGameGenerator;
  private GameGenerator twoGameGenerator;

  @BeforeEach
  void setUp() {
    oneGameGenerator = new GameGenerator(new OrderSheet(1000L), new TestRandomNumberGenerateStrategy(TestUtil.getOneToSixLottoNumbers()));
    twoGameGenerator = new GameGenerator(new OrderSheet(2000L), new TestRandomNumberGenerateStrategy(TestUtil.getOneToSixLottoNumbers()));
  }

  @DisplayName("지불 금액으로 살 수 있는 만큼의 로또를 생성한다.")
  @Test
  void generateNewLottoGames() {
    //given
    List<LottoGame> expectOneGame = Lists.newArrayList(LottoGame.createAutoGame(new LottoNumbers(getOneToSixLottoNumbers())));
    List<LottoGame> expectTwoGames = Lists.newArrayList(LottoGame.createAutoGame(new LottoNumbers(getOneToSixLottoNumbers())), LottoGame.createAutoGame(new LottoNumbers(getOneToSixLottoNumbers())));

    assertAll(
        () -> assertThat(oneGameGenerator.generateNewLottoGames()).isEqualTo(new LottoGames(expectOneGame)),
        () -> assertThat(twoGameGenerator.generateNewLottoGames()).isEqualTo(new LottoGames(expectTwoGames))
    );
  }

  @DisplayName("로또 구매에 지불한 금액을 반환한다.")
  @Test
  void peekTotalOrderedAmount() {
    assertThat(oneGameGenerator.peekTotalOrderedAmount()).isEqualTo(1000L);
  }

  @DisplayName("전해진 숫자로 이루어진 로또 게임을 생성한다.")
  @Test
  void createLottoGame() {
    //given
    List<Integer> givenNumbers = IntStream.rangeClosed(1, 6)
                                .mapToObj(number -> number * 2)
                                .collect(Collectors.toList());

    assertThat(oneGameGenerator.createLottoGame(givenNumbers)).isEqualTo(TestUtil.createAutoLottoGameFromLottoNumbers("2,4,6,8,10,12"));
  }
}
