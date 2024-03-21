package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
  static List<int[]> lotteryNumberArrayProvider() {
    return List.of(
            new int[] {1, 2, 3, 4, 5, 6},
            new int[] {1, 2, 3, 4, 5, 6, 7, 8}
    );
  }

  @ParameterizedTest
  @MethodSource("lotteryNumberArrayProvider")
  void 입력된_숫자가_7개_아니면_생성_불가(int... numbers) {
    assertThatThrownBy(() -> Lotto.of(numbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Wrong number of balls!");
  }

  @Test
  void 당첨숫자에_대한_복권_결과() {
    final Lotto lotto = new Lotto(LottoBalls.of(1, 2, 3, 4, 5, 6, 7));
    final LottoBalls winningBalls = LottoBalls.of(1, 2, 3, 4, 5, 6, 8);
    assertThat(lotto.result(winningBalls)).isEqualTo(Result.of(PositiveNumber.of(6), false));
  }

  @Test
  void 당첨숫자에_대한_복권_결과2() {
    final Lotto lotto = new Lotto(LottoBalls.of(1, 2, 3, 4, 5, 6, 7));
    final LottoBalls winningBalls = LottoBalls.of(1, 2, 3, 4, 5, 7, 7);
    assertThat(lotto.result(winningBalls)).isEqualTo(Result.of(PositiveNumber.of(5), true));
  }

  @Test
  void 당첨숫자에_대한_복권_결과3() {
    final Lotto lotto = new Lotto(LottoBalls.of(1, 2, 3, 4, 5, 6, 7));
    final LottoBalls lottoBalls = LottoBalls.of(1, 2, 3, 4, 5, 7, 8);
    assertThat(lotto.result(lottoBalls)).isEqualTo(Result.of(PositiveNumber.of(5), false));
  }

  @Test
  void 구매_가능한_복권_수() {
    PositiveNumber count = Lotto.count(PositiveNumber.of(1000));
    assertThat(count).isEqualTo(PositiveNumber.of(1));
  }
}
