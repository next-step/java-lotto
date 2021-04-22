package lotto.domain.place;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlacesTest {

  @Test
  @DisplayName("로또 등수 일급 컬렉션 클래스를 생성한다.")
  void create() {
    // given
    Places places = Places.create();

    // when
    places = places.record(Rank.FIRST.getCountOfMatch(), false);
    places = places.record(Rank.SECOND.getCountOfMatch(), true);

    // then
    assertThat(places.getValues())
            .contains(FirstPlace.create().win(),
                    SecondPlace.create().win(),
                    ThirdPlace.create());
  }
}