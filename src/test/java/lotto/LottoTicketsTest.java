package lotto;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.LottoGameConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.NUMBERS_PER_BUNDLE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

  LottoTicket sampleTicket;

  @BeforeEach
  void setUp() {
    LottoNumberBundle bundle = IntStream
        .range(MINIMUM_LOTTO_NUMBER, MINIMUM_LOTTO_NUMBER + NUMBERS_PER_BUNDLE)
        .mapToObj(LottoNumber::get)
        .collect(Collectors.collectingAndThen(toList(), LottoNumberBundle::of));
    this.sampleTicket = LottoTicket.of(bundle);
  }

  @Test
  @DisplayName("티켓 생성 테스트")
  void testOf() {
    assertThatExceptionOfType(NullPointerException.class).isThrownBy(
        () -> LottoTickets.of(null)
    );
  }

  @Test
  @DisplayName("로또 정산 결과가 정상으로 나오는지 테스트")
  void testResult() {

    LottoTickets tickets = IntStream
        .range(0, 2)
        .mapToObj(x -> this.sampleTicket)
        .collect(collectingAndThen(toList(), LottoTickets::of));

    WinningNumber winningNumber = WinningNumber.of(LottoNumberBundle.of("1, 2, 3, 4, 5, 6"));
    LottoNumber bonusNumber = LottoNumber.of(7);

    LottoResult result = tickets.settle(winningNumber, bonusNumber);

    assertThat(result.calculateIncome())
        .isEqualTo(Rank.FIRST.getWinningReward() * 2);
  }
}
