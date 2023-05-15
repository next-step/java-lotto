package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleNumberGeneratorTest {

    @Test
    @DisplayName("생성된 숫자는 6개이다.")
    public void generateNumberTest() {
        assertThat(new step3.domain.SimpleNumberGenerator().generateNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("생성된 숫자는 0보다 크고 45보다 같거나 작다.")
    public void numberRangeTest() {
        new step3.domain.SimpleNumberGenerator().generateNumbers().forEach(
                number -> assertThat(number > 0 && number <= 45).isTrue()
        );
    }

    @Test
    @DisplayName("생성된 숫자는 오름차순 정렬이다.")
    public void sortedTest() {
        List<Integer> numbers = new SimpleNumberGenerator().generateNumbers();
        for (int i = 1; i < numbers.size(); i++) {
            assertThat(numbers.get(i) > numbers.get(i - 1)).isTrue();
        }
    }
}
