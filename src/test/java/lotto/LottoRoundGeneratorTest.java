package lotto;

import java.util.List;
import lotto.domain.game.LottoGameSetting;
import lotto.domain.game.LottoPurchasePrice;
import lotto.domain.raffle.LottoRaffleGenerator;
import lotto.domain.round.LottoRound;
import lotto.domain.round.LottoRoundGenerator;
import lotto.domain.round.LottoRoundNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRoundGeneratorTest {

  private LottoGameSetting gameSetting;

  @BeforeEach
  void setup() {
    LottoRaffleGenerator fixedRaffleGenerator = () -> new LottoRoundNumbers(List.of(1, 2, 3, 40, 41, 42));
    gameSetting = LottoGameSetting.builder()
        .raffleGenerator(fixedRaffleGenerator)
        .pricePerGame(1000)
        .distinctNumberOnly(true)
        .build();
  }

  @Test
  @DisplayName("LottoRoundGenerator | 로또 구매 방식이 수동 자동인경우, 합쳐서 구매 가격만큼 로또 라운드를 생성한다.")
  void 수동이_포함된_게임_생성() {
    // given
    LottoPurchasePrice purchasePrice = new LottoPurchasePrice(gameSetting, 10_000);
    List<List<Integer>> manualRounds = List.of(
        List.of(1, 2, 3, 4),
        List.of(1, 2, 3, 4),
        List.of(1, 2, 3, 4),
        List.of(1, 2, 3, 4)
    );

    LottoRoundGenerator roundGenerator = new LottoRoundGenerator(manualRounds, purchasePrice, gameSetting);

    // when
    List<LottoRound> lottoRounds = roundGenerator.generateRounds();

    // then
    Assertions.assertThat(lottoRounds)
        .hasSize(10);
  }

  @Test
  @DisplayName("LottoRoundGenerator | 로또 구매 방식이 모두 수동이면 수동으로만 로또 라운드를 생성한다.")
  void 수동만_포함된_게임_생성() {
    // given
    LottoPurchasePrice purchasePrice = new LottoPurchasePrice(gameSetting, 4000);
    List<List<Integer>> manualRounds = List.of(
        List.of(1, 2, 3, 4),
        List.of(1, 2, 3, 4),
        List.of(1, 2, 3, 4),
        List.of(1, 2, 3, 4)
    );

    LottoRoundGenerator roundGenerator = new LottoRoundGenerator(manualRounds, purchasePrice, gameSetting);

    // when
    List<LottoRound> lottoRounds = roundGenerator.generateRounds();

    // then
    Assertions.assertThat(lottoRounds)
        .hasSize(4);
  }

  @Test
  @DisplayName("LottoRoundGenerator |로또 구매 방식이 자동인 경우, 자동으로만 지불한 가격만큼의 로또 라운드를 생성한다.")
  void 자동만_포함된_게임_생성() {

    // given
    LottoPurchasePrice purchasePrice = new LottoPurchasePrice(gameSetting, 4000);
    LottoRoundGenerator roundGenerator = new LottoRoundGenerator(purchasePrice, gameSetting);

    // when
    List<LottoRound> lottoRounds = roundGenerator.generateRounds();

    // then
    Assertions.assertThat(lottoRounds)
        .hasSize(4);
  }
}
