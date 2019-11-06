package step2_bak;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1:1:1",
            "2:2:1,2",
            "3:3:1,2,3"
    }, delimiter = ':')
    @DisplayName("범위내에서 개수만큼의 다른 숫자 출력")
    void uniqueNumbersTest(int range, int limit, String inputs) {
        Set<Integer> list =
                Arrays.stream(inputs.split(",")).map(Integer::parseInt).collect(toSet());
        AutoGame autoGame = new AutoGame(1, range);
        assertThat(autoGame.getNumbers(limit)).isEqualTo(list);
    }
}