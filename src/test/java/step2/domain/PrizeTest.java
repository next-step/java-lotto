package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PrizeTest {

    // init
    @DisplayName("init Class 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testInitClassWithNormalInput(int input) {

        Prize prize = Prize.of(input, 100000);

        assertThat(prize.getMatchedNumber()).isEqualTo(input);

    }

    // init
    @DisplayName("init Class negative data")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2})
    public void testInitClassWithError1(int input) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Prize.of(input, 1));

    }

}
