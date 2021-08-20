package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AvailableNumbersTest {

    @Test
    void create() {
        int minNumber = -1;
        int maxNumber = 45;

        assertThatThrownBy(() -> {
            AvailableNumbers availableNumbers = new AvailableNumbers(minNumber, maxNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void subList() {
        int minNumber = 1;
        int maxNumber = 45;

        AvailableNumbers availableNumbers = new AvailableNumbers(minNumber, maxNumber);
        assertThat(Arrays.equals(availableNumbers.subList(0,6).toArray(), Arrays.asList(1,2,3,4,5,6).toArray())).isTrue();
        assertThat(Arrays.equals(availableNumbers.subList(0,6).toArray(), Arrays.asList(6,5,4,3,2,1).toArray())).isFalse();
    }
}