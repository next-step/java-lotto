package lotto.domain;

import lotto.domain.place.FirstPlace;
import lotto.domain.place.Places;
import lotto.function.SixLottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

  @Test
  @DisplayName("지급한 돈에 맞게 로또를 생성한다.")
  void toBuy() {
    // given
    int money = 2_000;

    // when
    LottoTicket lottoTicket = LottoTicket.toBuy(money, new SixLottoNumbers(), new ArrayList<>());

    // then
    assertThat(lottoTicket.ticketCount()).isEqualTo(2);
  }

  @Test
  @DisplayName("수동 로또를 포함하여 로또를 생성한다.")
  void toBuyIncludeManualLotto() {
    // given
    int money = 3_000;

    // when
    LottoTicket lottoTicket = LottoTicket.toBuy(money,
            new SixLottoNumbers(),
            Arrays.asList("1, 2, 3, 4, 5, 6"));

    // then
    assertThat(lottoTicket.getValues())
            .contains(Lottery.generateSixNumbersFromStringNumbers("1, 2, 3, 4, 5, 6"));
  }

  @Test
  @DisplayName("지급한 돈에 비해 수동 로또를 넘게 생성할 시 예외가 발생한다.")
  void toBuyIncludeManualLotto_error() {
    // given
    int money = 0;

    // when

    // then
    assertThatThrownBy(() -> LottoTicket.toBuy(money,
            new SixLottoNumbers(),
            Arrays.asList("1, 2, 3, 4, 5, 6")))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("구입 금액에 맞는 구매할 로또 총 수는 %d 입니다.", 0);
  }

  @Test
  @DisplayName("로또 당첨번호와 비교하여 로또 등수 일급 컬렉션 클래스를 반환한다.")
  void matchedLottoPlaces() {
    // given
    LottoTicket lottoTicket = LottoTicket.toBuy(3_000, () -> IntStream.rangeClosed(1, 6)
                    .mapToObj(LottoNumber::generate)
                    .collect(Collectors.toList()), new ArrayList<>());

    // when
    Places places = lottoTicket.getMatchedPlaces(WiningLottery.generate("1,2,3,4,5,6"),
            BonusBall.valueOf(10));

    // then
    assertThat(places.getValues())
            .contains(FirstPlace.create().win().win().win());
  }
}