package lotto;

import static lotto.LottoGameConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.NUMBERS_PER_TICKET;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberPoolTest {

  PublishStrategy strategy = () -> IntStream
      .range(MINIMUM_LOTTO_NUMBER, MINIMUM_LOTTO_NUMBER + NUMBERS_PER_TICKET)
      .mapToObj(LottoNumber::get)
      .collect(Collectors.toList());

  @Test
  @DisplayName("abc")
  void publishTicket() {
    List<LottoNumber> expected = IntStream
        .range(MINIMUM_LOTTO_NUMBER, MINIMUM_LOTTO_NUMBER + NUMBERS_PER_TICKET)
        .mapToObj(LottoNumber::get)
        .collect(Collectors.toList());

    assertThat(NumberPool.generateNumberBundle(strategy))
        .isEqualTo(expected);
  }
}
