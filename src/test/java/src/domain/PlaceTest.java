package src.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaceTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void 승리_Place를_구할_수_있다(int matchCount) {
        List<Place> places = Place.winningPlaces();
        Place winningPlace = Place.byMatchedCount(matchCount);

        assertThat(places).contains(winningPlace);
    }
}
