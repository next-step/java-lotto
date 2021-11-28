package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {
    private final List<Integer> integersFixture = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

    @DisplayName("빈 생성자 호출시 List<Integer> 멤버 변수(1~45 사이의 Integer 6개) numbers를 가진 일급 컬렉션 Numbers를 생성한다.")
    @Test
    void create() {
        Numbers numbers = new Numbers();
        assertThat(numbers.getNumbers()).isInstanceOf(List.class);
        assertThat(numbers.getNumbers().get(0)).isInstanceOf(Integer.class);
        assertThat(numbers.getNumbers().size()).isEqualTo(6);
        numbers.getNumbers().forEach(i -> assertThat(i).isBetween(1, 45));
    }

    @DisplayName("List<Integer> 를 전달 받아 Numbers를 생성한다.")
    @Test
    void createWithList() {
        Numbers numbers = new Numbers(integersFixture);
        assertThat(numbers.getNumbers()).isInstanceOf(List.class);
        assertThat(numbers.getNumbers().get(0)).isInstanceOf(Integer.class);
        assertThat(numbers.getNumbers().size()).isEqualTo(6);
        numbers.getNumbers().forEach(i -> assertThat(i).isBetween(1, 45));
    }

    @DisplayName("List<Integer> size가 6이 아닌 경우 IllegalArgumentException throw 한다.")
    @Test
    void createExceptionWithSize() {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        assertThatThrownBy(() -> new Numbers(integers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("size는 항상 6");
    }

    @DisplayName("1~45 사이 정수가 아닌 경우 IllegalArgumentException throw 한다.")
    @Test
    void createExceptionWithNumber() {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 50));
        assertThatThrownBy(() -> new Numbers(integers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~45 사이 값");
    }

    @DisplayName("match 함수는 prizeNumbers 와 일치하는 수를 반환한다.")
    @Test
    void match() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> prizeNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(new Numbers(numbers).match(new Numbers(prizeNumbers))).isEqualTo(6);

        numbers = Arrays.asList(1, 2, 3, 4, 5, 45);
        assertThat(new Numbers(numbers).match(new Numbers(prizeNumbers))).isEqualTo(5);

        numbers = Arrays.asList(1, 2, 3, 4, 44, 45);
        assertThat(new Numbers(numbers).match(new Numbers(prizeNumbers))).isEqualTo(4);

        numbers = Arrays.asList(1, 2, 3, 43, 44, 45);
        assertThat(new Numbers(numbers).match(new Numbers(prizeNumbers))).isEqualTo(3);

        numbers = Arrays.asList(1, 2, 42, 43, 44, 45);
        assertThat(new Numbers(numbers).match(new Numbers(prizeNumbers))).isEqualTo(2);

        numbers = Arrays.asList(1, 22, 42, 43, 44, 45);
        assertThat(new Numbers(numbers).match(new Numbers(prizeNumbers))).isEqualTo(1);

        numbers = Arrays.asList(11, 22, 42, 43, 44, 45);
        assertThat(new Numbers(numbers).match(new Numbers(prizeNumbers))).isEqualTo(0);
    }
}
