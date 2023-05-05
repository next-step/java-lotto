package lotto;

import java.util.Collections;
import java.util.List;
import lotto.domain.game.LottoGameGenerator;
import lotto.domain.game.LottoGameSetting;
import lotto.domain.game.LottoGameType;
import lotto.domain.game.LottoGameWrapper;
import lotto.domain.raffle.LottoRaffleGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGameGeneratorTest {

  private LottoRaffleGenerator fixedRaffleGenerator;
  private LottoGameSetting gameSetting;

  @BeforeEach
  void setup() {
    fixedRaffleGenerator = () -> List.of(1, 2, 3, 40, 41, 42);
    gameSetting = LottoGameSetting.builder()
        .raffleGenerator(fixedRaffleGenerator)
        .pricePerGame(1000)
        .distinctNumberOnly(true)
        .build();
  }

  @Test
  @DisplayName("로또 구매 방식이 수동, 자동인경우 섞어서 생성한다.")
  void 수동이_포함된_게임_생성() {
    // given
    int lottoPrice = 10_000;
    List<List<Integer>> manualRounds = List.of(
        List.of(1, 2, 3, 4),
        List.of(1, 2, 3, 4),
        List.of(1, 2, 3, 4),
        List.of(1, 2, 3, 4)
    );

    LottoGameGenerator gameGenerator = new LottoGameGenerator(lottoPrice, manualRounds, gameSetting);

    // when
    LottoGameWrapper lottoGameWrapper = gameGenerator.generateLottoGame();

    // then
    Assertions.assertThat(lottoGameWrapper.getIncludeGameTypes())
        .contains(LottoGameType.MANUAL)
        .contains(LottoGameType.AUTO);
  }

  @Test
  @DisplayName("로또 구매 방식이 모두 수동이면, 수동으로만 생성한다.")
  void 수동만_포함된_게임_생성() {
    // given
    int lottoPrice = 4000;
    List<List<Integer>> manualRounds = List.of(
        List.of(1, 2, 3, 4),
        List.of(1, 2, 3, 4),
        List.of(1, 2, 3, 4),
        List.of(1, 2, 3, 4)
    );

    LottoGameGenerator gameGenerator = new LottoGameGenerator(lottoPrice, manualRounds, gameSetting);

    // when
    LottoGameWrapper lottoGameWrapper = gameGenerator.generateLottoGame();

    // then
    Assertions.assertThat(lottoGameWrapper.getIncludeGameTypes())
        .contains(LottoGameType.MANUAL)
        .doesNotContain(LottoGameType.AUTO);
  }

  @Test
  @DisplayName("로또 구매 방식이 모두 자동인 경우, 수동없이 자동만 생성한다.")
  void 자동만_포함된_게임_생성() {

    // given
    int lottoPrice = 4000;
    List<List<Integer>> manualRounds = Collections.emptyList();
    LottoGameGenerator gameGenerator = new LottoGameGenerator(lottoPrice, manualRounds, gameSetting);

    // when
    LottoGameWrapper lottoGameWrapper = gameGenerator.generateLottoGame();

    // then
    Assertions.assertThat(lottoGameWrapper.getIncludeGameTypes())
        .contains(LottoGameType.AUTO)
        .doesNotContain(LottoGameType.MANUAL);
  }


  @ValueSource(ints = {13333, 12001, 10001})
  @ParameterizedTest(name = "입력금액이 한판당 금액으로 나눠 떨어지지 않으면 게임을 시작 할 수 없다: {0}")
  void 한판당_금액으로_나눠지지_않는_경우 (int given) {
    // when & then
    Assertions.assertThatThrownBy(() -> new LottoGameGenerator(given, gameSetting))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
