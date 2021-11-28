package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    @DisplayName("빈 생성자 호출시 List<Integer> 멤버 변수(1~45 사이의 Integer 6개) numbers를 가진 일급 컬렉션 Numbers를 생성한다.")
    @Test
    void create() {
        Numbers numbers = new Numbers();
        assertThat(numbers.getNumbers()).isInstanceOf(List.class);
        assertThat(numbers.getNumbers().get(0)).isInstanceOf(Integer.class);
        assertThat(numbers.getNumbers().size()).isEqualTo(6);
        numbers.getNumbers().forEach(i -> assertThat(i).isBetween(1, 45));
    }

}
