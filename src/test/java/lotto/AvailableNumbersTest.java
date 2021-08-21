package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AvailableNumbersTest {

    @Test
    @DisplayName("생성자 최소값 예외처리")
    void create() {
        int minNumber = -1;
        int maxNumber = 45;

        assertThatThrownBy(() -> {
            AvailableNumbers availableNumbers = new AvailableNumbers(minNumber, maxNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 길이 만큼 리스트 반환")
    void subList() {
        int minNumber = 1;
        int maxNumber = 45;

        AvailableNumbers availableNumbers = new AvailableNumbers(minNumber, maxNumber);
        assertThat(Arrays.equals(availableNumbers.subList(0,6).toArray(), Arrays.asList(1,2,3,4,5,6).toArray())).isTrue();
        assertThat(Arrays.equals(availableNumbers.subList(0,6).toArray(), Arrays.asList(6,5,4,3,2,1).toArray())).isFalse();
    }
}