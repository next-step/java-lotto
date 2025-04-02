package autoLotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class LottoTest {

    @DisplayName("넘겨받은 두개의 Set에서 겹치는 숫자의 개수 테스트")
    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4,5,6', '3,4,5,6,7,8', 4",
            "'10,20,30,40,41,42', '1,2,3,4,5,6', 0",
            "'1,2,3,4,5,6', '1,2,3,4,5,6', 6"
    })
    void countCommonNumbers_ShouldReturnCorrectCount(String lottoNumbersStr, String winningNumbersStr, int expectedCount) {
        Set<Integer> lottoNumbers = parseNumbers(lottoNumbersStr);
        Set<Integer> winningNumbers = parseNumbers(winningNumbersStr);

        Lotto lotto = new Lotto(lottoNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers);

        int commonCount = lotto.countCommonNumbers(winningLotto);

        assertEquals(expectedCount, commonCount);
    }


    private Set<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.replaceAll("[\"']", "").split(","))
                     .map(String::trim)   // 공백 제거
                     .map(Integer::parseInt)
                     .collect(Collectors.toSet());
    }
}

