package lotto.domain.place;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static base.BaseConstants.LOTTO_FIRST_PLACE_INDEX;
import static org.assertj.core.api.Assertions.assertThat;

class LottoPlacesTest {

  @Test
  @DisplayName("로또 등수 일급 컬렉션 클래스를 생성한다.")
  void create() {
    // given
    LottoPlaces places = LottoPlaces.create();

    // when
    final int matchedLottoCount = 6;
    places = places.record(matchedLottoCount);

    // then
    assertThat(places.getValues().get(LOTTO_FIRST_PLACE_INDEX))
            .isEqualTo(LottoFirstPlace.create().win());
  }
}