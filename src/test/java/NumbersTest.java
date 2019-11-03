import domain.Numbers;
import domain.SafeNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    @Test
    void 합테스트() {
        List<SafeNumber> safeNumbers = Arrays.asList(new SafeNumber("1"), new SafeNumber("2"), new SafeNumber("3"));
        Numbers numbers = new Numbers(safeNumbers);
        int result = numbers.getSum();

        assertThat(result).isEqualTo(6);
    }
}
