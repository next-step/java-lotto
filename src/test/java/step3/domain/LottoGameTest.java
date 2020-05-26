package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static step3.domain.LottoGenerator.generateLotto;

public class LottoGameTest {

  private static final String RATIO_FORMAT = "%.2f";
  private static final LottoNumber BONUS_NUMBER = LottoNumber.of("7");

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
          generateLotto("1,2,3,30,20,10")
      ).collect(toList())),
      generateLotto("1,2,3,4,5,6"),
      BONUS_NUMBER
    );
    return Stream.of(
      Arguments.of(lottoGame, Rank.SECOND, 1),
      Arguments.of(lottoGame, Rank.THIRD, 1),
      Arguments.of(lottoGame, Rank.FIFTH, 2)
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
    final long payoff = Rank.stream()
                            .mapToLong(Rank::getPrice)
                            .sum();
    final String payoffRatio1 = String.format(RATIO_FORMAT, payoff / (5.0 * Lotto.PRICE));
    final String payoffRatio2 = "0.00";
    final Lottos lottos = Lottos.of(
                            Stream.of(
                              generateLotto("1,2,3,4,5,6"),
                              generateLotto("1,2,3,4,5,7"),
                              generateLotto("1,2,3,4,5,10"),
                              generateLotto("1,2,3,4,20,10"),
                              generateLotto("1,2,3,30,20,10")
                            ).collect(toList())
                          );
    return Stream.of(
      Arguments.of(
        LottoGame.of(lottos, generateLotto("1,2,3,4,5,6"), BONUS_NUMBER),
        payoffRatio1
      ),
      Arguments.of(
        LottoGame.of(lottos, generateLotto("11,12,13,14,15,16"), BONUS_NUMBER),
        payoffRatio2
      )
    );
  }

  @DisplayName("로또의 랭킹을 검증하는 테스트")
  @ParameterizedTest
  @MethodSource("provideLottoGameAndLottoRank")
  void 로또_랭킹_테스트 (LottoGame lottoGame, Lotto lotto, Rank expected) {
    assertEquals(expected, lottoGame.getRankOfLotto(lotto));
  }

  private static Stream<Arguments> provideLottoGameAndLottoRank () {
    final LottoGame lottoGame = LottoGame.of(
                                  LottoShop.buyLotto(Lotto.PRICE),
                                  generateLotto("1,2,3,4,5,6"),
                                  BONUS_NUMBER
                                );
    return Stream.of(
      Arguments.of(lottoGame, generateLotto("1,2,3,4,5,6"), Rank.FIRST),
      Arguments.of(lottoGame, generateLotto("1,2,3,4,5,7"), Rank.SECOND),
      Arguments.of(lottoGame, generateLotto("1,2,3,4,5,8"), Rank.THIRD),
      Arguments.of(lottoGame, generateLotto("1,2,3,4,8,7"), Rank.FORTH),
      Arguments.of(lottoGame, generateLotto("1,2,3,9,8,7"), Rank.FIFTH),
      Arguments.of(lottoGame, generateLotto("1,2,13,14,15,16"), Rank.MISS),
      Arguments.of(lottoGame, generateLotto("1,12,13,14,15,16"), Rank.MISS),
      Arguments.of(lottoGame, generateLotto("11,12,13,14,15,16"), Rank.MISS)
    );
  }
}
