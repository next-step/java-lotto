package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class NumbersTest {

    @Test
    @DisplayName("리스트에서 첫 두 개의 숫자를 찾는 테스트")
    void findMember_메서드_테스트() {
        Numbers numbers = new Numbers(new ArrayList<>(List.of(2, 3, 4, 5)));
        assertThat(numbers.findNumbers()).isEqualTo(List.of(2, 3));
    }

    @Test
    @DisplayName("숫자를 리스트의 맨 앞에 추가하는 테스트")
    void addNumber_메서드_테스트() {
        Numbers numbers = new Numbers(new ArrayList<>(List.of(2, 3, 4, 5)));
        assertThat(numbers.addNumber(1)).isEqualTo(List.of(1, 2, 3, 4, 5));
    }

}