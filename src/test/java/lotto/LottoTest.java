package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class LottoTest {

    @Test
    @DisplayName("로또 번호는 정렬되어야 한다")
    void lottoNumbersAreSorted() {
        Lotto lotto = Lotto.createRandomly();
        List<Integer> lottoNumbers = LottoParserForTest.parse(lotto);
        Assertions.assertThat(lottoNumbers).isSorted();
    }

    @Test
    @DisplayName("로또 번호는 서로 다른 6개의 숫자여야 한다")
    void lottoNumbersAreDifferent() {
        Lotto lotto = Lotto.createRandomly();
        List<Integer> lottoNumbers = LottoParserForTest.parse(lotto);
        Assertions.assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

    private static class LottoParserForTest {
        private static final String DELIMITER = ",";

        public static List<Integer> parse(Lotto lotto) {
            return Arrays.stream(lotto.toString()
                    .substring(1, lotto.toString().length() - 1)
                    .split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
    }
}
