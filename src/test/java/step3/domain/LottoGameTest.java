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
  private static final Lottos lottos = Lottos.of(
    Stream.of(
      generateLotto("1,2,3,4,5,6"),
      generateLotto("1,2,3,4,5,7"),
      generateLotto("1,2,3,4,5,10"),
      generateLotto("1,2,3,4,20,10"),
      generateLotto("1,2,3,30,20,10")
    ).collect(toList())
  );

  @DisplayName("로또 당첨 금액 검증 테스트")
  @ParameterizedTest
  @MethodSource("provideLottoGameAndWinningPrice")
  void 로또_당첨_수익률_테스트 (LottoGame lottoGame, String expected) {
    String payoffRatio = String.format(RATIO_FORMAT, lottoGame.getPayoffRatio());
    assertEquals(expected, payoffRatio);
  }

  private static Stream<Arguments> provideLottoGameAndWinningPrice () {
    final long payoff = Rank.stream().mapToLong(Rank::getPrice).sum();
    final String payoffRatio1 = String.format(RATIO_FORMAT, payoff / (5.0 * Lotto.PRICE));
    final String payoffRatio2 = "0.00";
    return Stream.of(
      Arguments.of(
        LottoGame.of(
          lottos,
          Prizes.of(
            lottos,
            WinningLotto.of(generateLotto("1,2,3,4,5,6"), BONUS_NUMBER))),
        payoffRatio1
      ),
      Arguments.of(
        LottoGame.of(
          lottos,
          Prizes.of(
            lottos,
            WinningLotto.of(generateLotto("11,12,13,14,15,16"), BONUS_NUMBER))),
        payoffRatio2
      )
    );
  }
}
