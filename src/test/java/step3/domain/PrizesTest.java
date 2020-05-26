package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static step3.domain.LottoGenerator.generateLotto;

public class PrizesTest {

  private static final Prizes prizes = Prizes.of(
    Lottos.of(Stream.of(
      generateLotto("1,2,3,4,5,7"),
      generateLotto("1,2,3,4,5,8"),
      generateLotto("1,2,3,40,20,10"),
      generateLotto("1,2,3,30,20,10")
    ).collect(toList())),
    WinningLotto.of(
      generateLotto("1,2,3,4,5,6"),
      LottoNumber.of("7")
    )
  );

  @DisplayName("로또 당첨 수를 구하는 메소드 검증")
  @ParameterizedTest
  @MethodSource("provideWinningLottoCount")
  void 로또_당첨수_테스트 (Prizes prizes, Rank rank, long expected) {
    assertEquals(
      prizes.stream()
        .filter(prize -> prize.getRank().equals(rank))
        .map(Prize::getCount).findFirst().orElse(0L),
      expected
    );
  }

  private static Stream<Arguments> provideWinningLottoCount () {
    return Stream.of(
      Arguments.of(prizes, Rank.SECOND, 1),
      Arguments.of(prizes, Rank.THIRD, 1),
      Arguments.of(prizes, Rank.FIFTH, 2)
    );
  }

  @DisplayName("로또 당첨 금액을 구하는 테스트")
  @Test
  void 로또_당첨_금액_테스트 () {
    long expected = Rank.SECOND.getPrice() + Rank.THIRD.getPrice() + (Rank.FIFTH.getPrice() * 2);
    assertEquals(
      prizes.getPayoff(),
      expected
    );
  }
}
