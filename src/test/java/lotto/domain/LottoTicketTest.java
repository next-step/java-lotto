package lotto.domain;

import lotto.domain.place.LottoFirstPlace;
import lotto.domain.place.LottoPlaces;
import lotto.function.SixLottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

  @Test
  @DisplayName("지급한 돈에 맞게 로또를 생성한다.")
  void toBuy() {
    // given
    int money = 2_000;

    // when
    LottoTicket lottoTicket = LottoTicket.toBuy(money, new SixLottoNumbers());

    // then
    assertThat(lottoTicket.ticketCount()).isEqualTo(2);
  }

  @Test
  @DisplayName("로또 당첨번호와 비교하여 로또 등수 일급 컬렉션 클래스를 반환한다.")
  void matchedLottoPlaces() {
    // given
    LottoTicket lottoTicket = LottoTicket.toBuy(3_000, () -> IntStream.rangeClosed(1, 6)
            .mapToObj(LottoNumber::generate)
            .collect(Collectors.toList()));
    LottoBonusBall lottoBonusBall = LottoBonusBall.create(1);

    // when
    LottoPlaces places = lottoTicket.getMatchedLottoPlaces(LottoWiningNumbers.generate("1,2,3,4,5,6"), lottoBonusBall);

    // then
    assertThat(places.getValues())
            .contains(LottoFirstPlace.create().win().win().win());
  }
}