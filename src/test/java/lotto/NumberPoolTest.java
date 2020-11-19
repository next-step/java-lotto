package lotto;

import static lotto.LottoGameConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.NUMBERS_PER_TICKET;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberPoolTest {

  private PublishStrategy strategy;

  @BeforeEach
  void setUp() {
    strategy = () -> {
      List<LottoNumber> lottoNumbers = new ArrayList<>();
      for (int i = MINIMUM_LOTTO_NUMBER; i <= NUMBERS_PER_TICKET; i++) {
        lottoNumbers.add(LottoNumber.of(i));
      }
      return LottoTicket.of(lottoNumbers);
    };
  }

  @Test
  @DisplayName("로또 발급 기능 테스트")
  void publishTicket() {
    LottoTicket ticket = NumberPool.publishTicket(this.strategy);
    assertThat(ticket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
  }

  @Test
  @DisplayName("지정한 번호 가져오는 기능 테스트")
  void getNumber() {
    LottoNumber number = LottoNumber.of(1);

    assertThat(number).isEqualTo(NumberPool.getNumber(1));
  }
}