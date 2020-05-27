package lotto.step4.domain;

import lotto.step3.domain.LottoNumber;
import lotto.step3.domain.Prize;
import lotto.step3.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrizeTest {

  private static final String RATIO_FORMAT = "%.2f";
  private static final LottoNumber BONUS_NUMBER = LottoNumber.of("7");

  @DisplayName("로또 당첨 금액 검증 테스트")
  @ParameterizedTest
  @MethodSource("provideTotalPrice")
  void 로또_당첨_금액_테스트 (long totalPrice, long expected) {
    assertEquals(expected, totalPrice);
  }

  private static Stream<Arguments> provideTotalPrice () {
    return Stream.of(
      Arguments.of(
        Prize.of(Rank.FIRST, 1).getTotalPrize(),
        Rank.FIRST.getPrice() * 1
      ),
      Arguments.of(
        Prize.of(Rank.SECOND, 2).getTotalPrize(),
        Rank.SECOND.getPrice() * 2
      ),
      Arguments.of(
        Prize.of(Rank.THIRD, 3).getTotalPrize(),
        Rank.THIRD.getPrice() * 3
      ),
      Arguments.of(
        Prize.of(Rank.FORTH, 4).getTotalPrize(),
        Rank.FORTH.getPrice() * 4
      ),
      Arguments.of(
        Prize.of(Rank.FIFTH, 5).getTotalPrize(),
        Rank.FIFTH.getPrice() * 5
      )
    );
  }

}
