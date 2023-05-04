package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.domain.game.LottoGame;
import lotto.domain.game.LottoGameSetting;
import lotto.domain.game.LottoGameStatistics;
import lotto.domain.game.LottoWinType;
import lotto.domain.game.LottoWinningNumber;
import lotto.domain.raffle.LottoRaffleGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGameTest {

  private LottoRaffleGenerator fixedRaffleGenerator;
  private LottoRaffleGenerator duplicateFixedRaffleGenerator;
  private LottoGameSetting gameSetting;

  @BeforeEach
  void setup() {
    fixedRaffleGenerator = () -> List.of(1, 2, 3, 40, 50, 60);
    duplicateFixedRaffleGenerator = () -> List.of(1, 1, 2, 3, 4, 5);

    gameSetting = LottoGameSetting.builder()
        .raffleGenerator(fixedRaffleGenerator)
        .pricePerGame(1000)
        .distinctNumberOnly(true)
        .build();
  }

  @Test
  @DisplayName("LottoGame | 로또는 추첨 후 결과를 남긴다")
  void 로또는_추첨_후_항상_결과를_남긴다 () {

    // given
    LottoGame game = LottoGame.ofAutoOnly(14000, gameSetting);
    LottoWinningNumber 당첨번호 = new LottoWinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

    // when
    LottoGameStatistics statistics = game.play(당첨번호);

    // then
    Assertions.assertThat(statistics.getWinTypeMap())
        .containsKey(LottoWinType.RANK_5);
  }

  @ValueSource(ints = {13333, 12001, 10001})
  @ParameterizedTest(name = "1000으로 나눠지지 않는 값: {0}")
  void 로또는_1000으로_나눠지지_않으면_게임을_할_수_없다 (int given) {

    // when & then
    Assertions.assertThatThrownBy(() -> LottoGame.ofAutoOnly(given, gameSetting))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("LottoGame | 중복번호 허용이 안되면, 보너스 번호와 당첨번호 또한 중복 될 수 없다")
  void 중복번호_허용_불가_시_보너스번호도_중복_불가 () {

    // given
    LottoGameSetting setting = LottoGameSetting.builder()
        .raffleGenerator(fixedRaffleGenerator)
        .pricePerGame(1000)
        .distinctNumberOnly(true)
        .build();

    LottoGame game = LottoGame.ofAutoOnly(14000, setting);
    LottoWinningNumber 당첨번호 = new LottoWinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 3);

    // when & then
    Assertions.assertThatThrownBy(() -> game.play(당첨번호))
        .isInstanceOf(IllegalArgumentException.class);
  }
  @Test
  @DisplayName("LottoGame | 중복여부가 금지된 경우에는 로또번호에 중복이 존재 할 수 없다.")
  void 로또번호_중복_금지() {

    // given
    LottoGameSetting setting = LottoGameSetting.builder()
        .raffleGenerator(duplicateFixedRaffleGenerator)
        .pricePerGame(1000)
        .distinctNumberOnly(true)
        .build();

    // when && then
    Assertions.assertThatThrownBy(() -> LottoGame.ofAutoOnly(14000, setting))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
