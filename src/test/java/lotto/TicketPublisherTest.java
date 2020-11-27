package lotto;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.LottoGameConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.NUMBERS_PER_BUNDLE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.dto.TicketPublisherDTO;
import lotto.lottoexception.RemainBudgetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketPublisherTest {

  private final PublishStrategy sampleStrategy = () -> IntStream
      .range(MINIMUM_LOTTO_NUMBER, MINIMUM_LOTTO_NUMBER + NUMBERS_PER_BUNDLE)
      .mapToObj(LottoNumber::get)
      .collect(collectingAndThen(toList(), LottoNumberBundle::of));
  private TicketPublisher samplePublisher;

  @BeforeEach
  void setUp() {
    this.samplePublisher = new TicketPublisher();
  }

  @Test
  @DisplayName("발급된 티켓이 수동으로 발급한 티켓과 같은 지 확인")
  void publishLottoTickets() {
    LottoNumberBundle expected = IntStream
        .rangeClosed(MINIMUM_LOTTO_NUMBER, NUMBERS_PER_BUNDLE)
        .mapToObj(LottoNumber::of)
        .collect(Collectors.collectingAndThen(Collectors.toList(), LottoNumberBundle::of));

    assertThat(this.samplePublisher.publishAutoTicket(sampleStrategy).toString())
        .isEqualTo(LottoTicket.of(expected).toString());
  }

  @Test
  @DisplayName("부족한 Budget 을 가졌을 때 에러 처리 확인")
  void testWhenNotEnoughBudget() {
    assertThatExceptionOfType(RemainBudgetException.class)
        .isThrownBy(
            () -> Budget.of(500)
        );
  }

  @Test
  @DisplayName("금액을 초과한 수동 티켓 발급")
  void testPublishManualTicket() {
    Budget budget = Budget.of(1500);
    String[] inputs = {"1, 2, 3, 4, 5, 6", "2, 4, 6, 8, 10, 12"};
    List<LottoNumberBundle> bundles
        = Arrays.stream(inputs)
        .map(LottoNumberBundle::of)
        .collect(toList());

    assertThatExceptionOfType(RemainBudgetException.class).isThrownBy(
        () -> this.samplePublisher.publishManualTickets(bundles, budget)
    );
  }

  @Test
  @DisplayName("발급 갯수 확인")
  void testPublishingHistory() {
    Budget budget = Budget.of(10000);
    String[] inputs = {"1, 2, 3, 4, 5, 6", "2, 4, 6, 8, 10, 12"};
    List<LottoNumberBundle> bundles
        = Arrays.stream(inputs)
        .map(LottoNumberBundle::of)
        .collect(toList());

    this.samplePublisher.publishManualTickets(bundles, budget);
    this.samplePublisher.publishAutoTickets(budget);

    TicketPublisherDTO dto = this.samplePublisher.exportData();

    assertThat(dto.getPublishingHistory().get(TicketPublishType.MANUAL))
        .isEqualTo(2);

    assertThat(dto.getPublishingHistory().get(TicketPublishType.AUTO))
        .isEqualTo(8);
  }
}
