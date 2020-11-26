package lotto;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.LottoGameConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.NUMBERS_PER_BUNDLE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.lottoexception.RemainBudgetException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketPublisherTest {

  PublishStrategy sampleStrategy = new PublishStrategy() {
    @Override
    public List<LottoNumber> publish() {
      return null;
    }

    @Override
    public LottoNumberBundle publish1() {
      return IntStream
          .range(MINIMUM_LOTTO_NUMBER, MINIMUM_LOTTO_NUMBER + NUMBERS_PER_BUNDLE)
          .mapToObj(LottoNumber::get)
          .collect(collectingAndThen(toList(), LottoNumberBundle::of));
    }
  };

  @Test
  @DisplayName("발급된 티켓이 수동으로 발급한 티켓과 같은 지 확인")
  void publishLottoTickets() {
    LottoTicket expected = IntStream
        .rangeClosed(MINIMUM_LOTTO_NUMBER, NUMBERS_PER_BUNDLE)
        .mapToObj(LottoNumber::of)
        .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTicket::of));

    assertThat(TicketPublisher.publishTicket1(sampleStrategy).toString())
        .isEqualTo(expected.toString());
  }

  @Test
  @DisplayName("부족한 Budget 을 가졌을 때 에러 처리 확인")
  void testWhenNotEnoughBudget() {
    assertThatExceptionOfType(RemainBudgetException.class)
        .isThrownBy(() -> TicketPublisher.publishTickets1(Budget.of(500)));
  }
}
