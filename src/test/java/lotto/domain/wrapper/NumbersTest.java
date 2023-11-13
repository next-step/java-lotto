package lotto.domain.wrapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NumbersTest {

    @DisplayName("6개의 Number객체를 컬렉션으로 가지는 Numbers객체를 생성한다.")
    @Test
    void creatNumbers() {
        // given
        List<Integer> inputs = List.of(1, 5, 12, 21, 32, 43);

        // when
        Numbers numbers = new Numbers(inputs);

        // then
        assertThat(numbers.numbers()).hasSize(6)
            .contains(1, 5, 12, 21, 32, 43);
    }

    @DisplayName("자신이 가지고 있는 Number객체의 값과 인자로 받은 Number객체의 값이 몇 개 일치하는 지 확인하고 반환한다.")
    @Test
    void countMatchingNumbers() {
        // given
        List<Integer> originInputs = List.of(1, 5, 12, 21, 32, 43);
        List<Integer> targetInputs = List.of(5, 1, 21, 43, 30, 42);
        Numbers origin = new Numbers(originInputs);
        Numbers target = new Numbers(targetInputs);

        // when
        int total = origin.countMatchingNumbers(target);

        // then
        assertThat(total).isEqualTo(4);
    }
}
