package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static step2.util.ListUtil.numberOfMatches;

public class StatisticsCaculatorTest {

    @Test
    @DisplayName("숫자 비교를 통해 일치하는 수의 개수를 확인할 수 있다")
    public void integer_contain() {
        List<Integer> number1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> number2 = Arrays.asList(1, 2, 3, 9, 10, 11);

        assertThat(numberOfMatches(number1, number2)).isEqualTo(3);
    }

}
