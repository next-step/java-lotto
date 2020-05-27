package lotto.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static lotto.step3.domain.LottoGenerator.generateLotto;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {

  private static final LottoResult LOTTO_RESULT = LottoResult.of(
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
  void 로또_당첨수_테스트 (LottoResult lottoResult, Rank rank, long expected) {
    assertEquals(
      lottoResult.stream()
        .filter(prize -> prize.getRank().equals(rank))
        .map(Prize::getCount).findFirst().orElse(0L),
      expected
    );
  }

  private static Stream<Arguments> provideWinningLottoCount () {
    return Stream.of(
      Arguments.of(LOTTO_RESULT, Rank.SECOND, 1),
      Arguments.of(LOTTO_RESULT, Rank.THIRD, 1),
      Arguments.of(LOTTO_RESULT, Rank.FIFTH, 2)
    );
  }

  @DisplayName("로또 당첨 금액을 구하는 테스트")
  @Test
  void 로또_당첨_금액_테스트 () {
    long expected = Rank.SECOND.getPrice() + Rank.THIRD.getPrice() + (Rank.FIFTH.getPrice() * 2);
    assertEquals(
      LOTTO_RESULT.getPayoff(),
      expected
    );
  }
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

  @DisplayName("로또 당첨 금액의 수익률 검증 테스트")
  @ParameterizedTest
  @MethodSource("provideLottoGameAndWinningPrice")
  void 로또_당첨_수익률_테스트 (LottoResult lottoResult, String expected) {
    String payoffRatio = String.format(RATIO_FORMAT, lottoResult.resultLottoGamePayOffRatio());
    assertEquals(expected, payoffRatio);
  }

  private static Stream<Arguments> provideLottoGameAndWinningPrice () {
    final long payoff = Rank.stream().mapToLong(Rank::getPrice).sum();
    final String payoffRatio1 = String.format(RATIO_FORMAT, payoff / (5.0 * Lotto.PRICE));
    final String payoffRatio2 = "0.00";
    return Stream.of(
      Arguments.of(
        LottoResult.of(
          lottos,
          WinningLotto.of(generateLotto("1,2,3,4,5,6"), BONUS_NUMBER)
        ),
        payoffRatio1
      ),
      Arguments.of(
        LottoResult.of(
          lottos,
          WinningLotto.of(generateLotto("11,12,13,14,15,16"), BONUS_NUMBER)
        ),
        payoffRatio2
      )
    );
  }
}
