package lotto.domain;

import lotto.domain.place.LottoFirstPlace;
import lotto.domain.place.LottoPlaces;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

  private LottoStore store;

  @BeforeEach
  void setUp() {
    LottoWiningNumbers lottoWiningNumbers = LottoWiningNumbers.generate(() -> IntStream.rangeClosed(1, 6)
            .mapToObj(LottoNumber::generate)
            .collect(Collectors.toList()));
    int lottoBonusBallNumber = 1;
    store = LottoStore.open(lottoWiningNumbers, lottoBonusBallNumber);
  }

  @Test
  @DisplayName("로또 판매점을 생성한다.")
  void open() {
    // given

    // when

    // then
    assertThat(store).isNotNull();
  }

  @Test
  @DisplayName("소비자가 건내준 로또와 당첨 로또 번호와 비교하여 불변 객체로 반환한다.")
  void exchange() {
    // given
    final List<LottoNumber> consumer = IntStream.rangeClosed(1, 6)
            .mapToObj(LottoNumber::generate)
            .collect(Collectors.toList());
    LottoTicket lottoTicket = LottoTicket.toBuy(3000, () -> consumer);

    // when
    LottoPlaces places = store.exchange(lottoTicket).getLottoPlaces();

    // then
    assertThat(places.getValues().contains(LottoFirstPlace.create().win().win().win()))
            .isTrue();
  }
}