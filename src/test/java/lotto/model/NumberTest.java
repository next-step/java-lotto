package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 번호는 1~45 사이가 아니면 예외가 난다")
    public void invalidNumber(int invalidNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Number(invalidNumber));
    }

    @Test
    @DisplayName("로또 번호는 비교 가능하다")
    public void compareTo() {
        Number num1 = new Number(1);
        Number num2 = new Number(2);
        Number num3 = new Number(3);

        assertThat(num1).isLessThan(num2);
        assertThat(num2).isLessThan(num3);
        assertThat(num2).isLessThan(num3);

    }

    @Test
    @DisplayName("로또 번호는 동등 판단이 가능하다")
    public void equals() {
        Number num1 = new Number(1);
        Number num2 = new Number(1);

        assertThat(num1).isEqualTo(num2);
    }


    @Test
    @DisplayName("로또 번호로 가능한 숫자는 1~45이다")
    public void allRange() {
        List<Integer> result = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(toList());
        
        assertThat(Number.all()).containsExactlyElementsOf(result);
    }

}