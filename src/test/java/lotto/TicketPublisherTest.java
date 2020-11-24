package lotto;

import static lotto.LottoGameConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.NUMBERS_PER_TICKET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.lottoexception.RemainBudgetException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketPublisherTest {

  PublishStrategy sampleStrategy = () -> IntStream
      .range(MINIMUM_LOTTO_NUMBER, NUMBERS_PER_TICKET + 1)
      .mapToObj(LottoNumber::get)
      .collect(Collectors.toList());

  @Test
  @DisplayName("발급된 티켓이 수동으로 발급한 티켓과 같은 지 확인")
  void publishLottoTickets() {
    LottoTicket expected = IntStream
        .range(MINIMUM_LOTTO_NUMBER, NUMBERS_PER_TICKET + 1)
        .mapToObj(LottoNumber::of)
        .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTicket::of));

    assertThat(TicketPublisher.publishTicket(sampleStrategy).toString())
        .isEqualTo(expected.toString());
  }

  @Test
  @DisplayName("부족한 Budget 을 가졌을 때 에러 처리 확인")
  void testWhenNotEnoughBudget() {
    Budget budget = Budget.of(500);

    assertThatExceptionOfType(RemainBudgetException.class)
        .isThrownBy(() -> TicketPublisher.publishTickets(budget));
  }
}
