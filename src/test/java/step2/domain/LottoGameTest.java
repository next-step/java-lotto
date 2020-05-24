package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static step2.domain.LottoGenerator.generateLotto;

public class LottoGameTest {

  private static final String RATIO_FORMAT = "%.2f";

  @DisplayName("로또 당첨 수를 구하는 메소드 검증")
  @ParameterizedTest
  @MethodSource("provideWinningLottoCount")
  void 로또_당첨수_테스트 (LottoGame lottoGame, Rank rank, long expected) {
    assertEquals(expected, lottoGame.getWinningCount(rank));
  }

  private static Stream<Arguments> provideWinningLottoCount () {
    final LottoGame lottoGame = LottoGame.of(
      Lottos.of(Stream.of(
          generateLotto("1,2,3,4,5,7"),
          generateLotto("1,2,3,4,5,8"),
          generateLotto("1,2,3,40,20,10"),
          generateLotto("1,2,3,30,20,10")).collect(toList())),
      generateLotto("1,2,3,4,5,6")
    );
    return Stream.of(
      Arguments.of(lottoGame, Rank.SECOND, 2),
      Arguments.of(lottoGame, Rank.FORTH, 2)
    );
  }

  @DisplayName("로또 당첨 금액 검증 테스트")
  @ParameterizedTest
  @MethodSource("provideLottoGameAndWinningPrice")
  void 로또_당첨_수익률_테스트 (LottoGame lottoGame, String expected) {
    String payoffRatio = String.format(RATIO_FORMAT, lottoGame.getPayoffRatio());
    assertEquals(expected, payoffRatio);
  }

  private static Stream<Arguments> provideLottoGameAndWinningPrice () {
    long payoff = Rank.stream()
                      .mapToLong(Rank::getPrice)
                      .sum();
    String payoffRatio = String.format(RATIO_FORMAT, payoff / 4000.0);
    Lottos lottos = Lottos.of(
                            Stream.of(
                              generateLotto("1,2,3,4,5,6"),
                              generateLotto("1,2,3,4,5,10"),
                              generateLotto("1,2,3,4,20,10"),
                              generateLotto("1,2,3,30,20,10")
                            ).collect(toList()));
    return Stream.of(
      Arguments.of(LottoGame.of(lottos, generateLotto("1,2,3,4,5,6")), payoffRatio),
      Arguments.of(LottoGame.of(lottos, generateLotto("11,12,13,14,15,16")), "0.00")
    );
  }
}
