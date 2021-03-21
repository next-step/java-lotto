package study.step2;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study.step2.domain.Lotto;

public class LottoTest {

    @ParameterizedTest(name = "로또 넘버 정렬 테스트")
    @CsvSource(value = {"26,42,7,39,15,1:1,7,15,26,39,42", "36,2,20,3,8,34:2,3,8,20,34,36"}, delimiter = ':')
    public void sortedNumbers(String inputs, String expected) {
        List<Integer> inputNumbers = Arrays.stream(expected.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        List<Integer> expectNumbers = Arrays.stream(expected.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        Lotto lotto = new Lotto(inputNumbers);
        assertThat(lotto.getLottoNumbers()).isEqualTo(expectNumbers);
    }
}
