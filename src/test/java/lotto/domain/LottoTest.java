package lotto.domain;

import lotto.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

public class LottoTest {
  private static List<int[]> lotteryNumberArrayProvider() {
    return List.of(
            new int[]{1, 2, 3, 4, 5},
            new int[]{1, 2, 3, 4, 5, 6, 7}
    );
  }

  @ParameterizedTest
  @MethodSource("lotteryNumberArrayProvider")
  void 입력된_번호_숫자가_6개_아니면_생성_불가(int... numbers) {
    assertThatThrownBy(() -> Lotto.of(LottoBalls.of(numbers)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Wrong number of balls!");
  }

  private static Stream<Arguments> lottoResultTestParameterGenerator() {
    return Stream.of(
            arguments(Lotto.of(LottoBalls.of(1, 2, 3, 4, 5, 6)), Lottery.of(LottoBall.of(8), LottoBalls.of(1, 2, 3, 4, 5, 6)), 6, false),
            arguments(Lotto.of(LottoBalls.of(1, 2, 3, 4, 5, 6)), Lottery.of(LottoBall.of(6), LottoBalls.of(1, 2, 3, 4, 5, 7)), 5, true),
            arguments(Lotto.of(LottoBalls.of(2, 3, 4, 5, 6, 7)), Lottery.of(LottoBall.of(11), LottoBalls.of(1, 2, 3, 4, 6, 7)), 2, false)
    );
  }

  @ParameterizedTest
  @MethodSource("lottoResultTestParameterGenerator")
  void 당첨숫자에_대한_복권_결과(Lotto lotto, Lottery lottery, int matchCount, boolean bonusMatched) {
    assertThat(lotto.result(lottery)).isEqualTo(Result.of(PositiveNumber.of(matchCount), bonusMatched));
  }

  @Test
  void 구매_가능한_복권_수() {
    PositiveNumber count = Lotto.count(PositiveNumber.of(1000));
    assertThat(count).isEqualTo(PositiveNumber.of(1));
  }
}
