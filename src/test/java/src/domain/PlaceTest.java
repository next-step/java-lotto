package src.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlaceTest {

    @ParameterizedTest
    @CsvSource(value = {"3:false", "4:false", "5:false", "5:true", "6:false"}, delimiter = ':')
    void 승리_Place를_구할_수_있다(int matchCount, boolean matchBonus) {
        List<Place> places = Place.winningPlaces();
        Place winningPlace = Place.byMatchCount(matchCount, matchBonus);

        assertThat(places).contains(winningPlace);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void winningPlaces_당첨금이_없는_패배_place는_반환하지_않는다(int matchCount) {
        List<Place> places = Place.winningPlaces();
        Place place = Place.byMatchCount(matchCount, false);

        assertThat(places).isNotEmpty()
                .doesNotContain(place);
    }

    @Test
    void 볼_5개와_보너스_볼이_맞으면_2등이다() {
        // given
        int matchCount = 5;
        boolean matchBonus = true;

        // when
        Place place = Place.byMatchCount(matchCount, matchBonus);

        // then
        assertThat(place).isEqualTo(Place.SECOND_PLACE);
    }

    @Test
    void 볼_5개와_보너스_볼이_맞지_않으면_3등이다() {
        // given
        int matchCount = 5;
        boolean matchBonus = false;

        // when
        Place place = Place.byMatchCount(matchCount, matchBonus);

        // then
        assertThat(place).isEqualTo(Place.THIRD_PLACE);
    }
}
