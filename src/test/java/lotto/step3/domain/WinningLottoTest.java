package lotto.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.step3.domain.LottoGenerator.generateLotto;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningLottoTest {

  private static final LottoNumber BONUS_NUMBER = LottoNumber.of("7");

  @DisplayName("로또의 랭킹을 검증하는 테스트")
  @ParameterizedTest
  @MethodSource("provideWinningLottoAndLottoRank")
  void 로또_랭킹_테스트 (WinningLotto winningLotto, Lotto lotto, Rank expected) {
    assertEquals(expected, winningLotto.getRankOfLotto(lotto));
  }

  private static Stream<Arguments> provideWinningLottoAndLottoRank () {
    final WinningLotto winningLotto = WinningLotto.of(
      generateLotto("1,2,3,4,5,6"),
      BONUS_NUMBER
    );
    return Stream.of(
      Arguments.of(winningLotto, generateLotto("1,2,3,4,5,6"), Rank.FIRST),
      Arguments.of(winningLotto, generateLotto("1,2,3,4,5,7"), Rank.SECOND),
      Arguments.of(winningLotto, generateLotto("1,2,3,4,5,8"), Rank.THIRD),
      Arguments.of(winningLotto, generateLotto("1,2,3,4,8,7"), Rank.FORTH),
      Arguments.of(winningLotto, generateLotto("1,2,3,9,8,7"), Rank.FIFTH),
      Arguments.of(winningLotto, generateLotto("1,2,13,14,15,16"), Rank.MISS),
      Arguments.of(winningLotto, generateLotto("1,12,13,14,15,16"), Rank.MISS),
      Arguments.of(winningLotto, generateLotto("11,12,13,14,15,16"), Rank.MISS)
    );
  }
}
