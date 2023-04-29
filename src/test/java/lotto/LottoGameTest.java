package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lotto.domain.game.LottoGame;
import lotto.domain.game.LottoGameStatistics;
import lotto.domain.game.LottoWinType;
import lotto.domain.raffle.LottoRaffleGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGameTest {

  private LottoRaffleGenerator fixedRaffleGenerator;

  @BeforeEach
  void setup() {
    fixedRaffleGenerator = () -> Set.of(1, 2, 3, 40, 50, 60);
  }

  @Test
  @DisplayName("LottoGame | 로또는 추첨 후 결과를 남긴다")
  void 로또는_추첨_후_항상_결과를_남긴다 () {

    // given
    LottoGame game = new LottoGame(14000, fixedRaffleGenerator);
    Set<Integer> 당첨번호 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

    // when
    LottoGameStatistics statistics = game.play(당첨번호);

    // then
    Assertions.assertThat(statistics.getWinTypeMap())
        .containsKey(LottoWinType.RANK_4);
  }

  @ValueSource(ints = {13333, 12001, 10001})
  @ParameterizedTest(name = "1000으로 나눠지지 않는 값: {0}")
  void 로또는_1000으로_나눠지지_않으면_게임을_할_수_없다 (int given) {

    // when & then
    Assertions.assertThatThrownBy(() -> new LottoGame(given, fixedRaffleGenerator))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
