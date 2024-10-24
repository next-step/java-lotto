package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UniqueRandomNumberProviderTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1", "1,45", "45,45"}, delimiter = ',')
    public void 중복되지않는_숫자_생성(int min, int max) {
        List<Integer> numbers = UniqueRandomNumberProvider.provideInRange(min, max, max - min + 1);

        List<Integer> result = IntStream.rangeClosed(min, max).boxed().collect(Collectors.toList());
        assertThat(numbers).containsExactlyInAnyOrderElementsOf(result);
    }
}
