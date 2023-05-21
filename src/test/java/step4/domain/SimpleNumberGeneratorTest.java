package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.SimpleNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleNumberGeneratorTest {

    @Test
    @DisplayName("생성된 숫자는 6개이다.")
    public void generateNumberTest() {
        assertThat(new SimpleNumberGenerator().generateNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("생성된 숫자는 오름차순 정렬이다.")
    public void sortedTest() {
        List<LottoNumber> numbers = new SimpleNumberGenerator().generateNumbers();
        for (int i = 1; i < numbers.size(); i++) {
            assertThat(numbers.get(i).compareTo(numbers.get(i - 1))).isEqualTo(1);
        }
    }
}
