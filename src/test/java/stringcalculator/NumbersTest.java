package stringcalculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import stringcalculator.domain.Numbers;

class NumbersTest {

    @Test
    void 숫자_이외의_값_음수를_전달하면_에러_반환() {
        List<String> numbers = Arrays.asList("1", "2", "-11as", "a");
        assertThatThrownBy(() -> new Numbers(numbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 숫자리스트_계산_테스트() {
        Assertions.assertThat(new Numbers(Arrays.asList("1", "2", "3")).sum()).isEqualTo(6);
    }
}



