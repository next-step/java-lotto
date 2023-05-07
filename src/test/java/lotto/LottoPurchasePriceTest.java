package lotto;

import java.util.List;
import lotto.domain.game.LottoGameSetting;
import lotto.domain.game.LottoPricePerGame;
import lotto.domain.game.LottoPurchasePrice;
import lotto.domain.raffle.LottoRaffleGenerator;
import lotto.domain.round.LottoRoundNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPurchasePriceTest {
  private LottoRaffleGenerator fixedRaffleGenerator;
  private LottoGameSetting gameSetting;

  @BeforeEach
  void setup() {
    fixedRaffleGenerator = () -> new LottoRoundNumbers(List.of(1, 2, 3, 40, 41, 42));
    gameSetting = LottoGameSetting.builder()
        .raffleGenerator(fixedRaffleGenerator)
        .pricePerGame(1000)
        .distinctNumberOnly(true)
        .build();
  }

  @ValueSource(ints = {13333, 12001, 10001})
  @ParameterizedTest(name = "LottoPricePerGame | 입력금액이 한판당 금액으로 나눠 떨어지지 않으면 게임을 시작 할 수 없다: {0}")
  void 한판당_금액으로_나눠지지_않는_경우 (int given) {
    // when & then
    Assertions.assertThatThrownBy(() -> new LottoPurchasePrice(gameSetting, given))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
