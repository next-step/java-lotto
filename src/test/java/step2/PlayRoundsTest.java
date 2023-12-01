package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayRoundsTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 3000, 13500})
    void getPlayRounds(int price) {
        assertThat(PlayRounds.getPlayRounds(price)).isEqualTo(price/1000);
    }
}