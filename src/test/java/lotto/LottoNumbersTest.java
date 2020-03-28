package lotto;

import lotto.domain.LottoNumbers;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {

    @Test
    @DisplayName("같은 숫자의 로또 번호는 같은 로또 번호이다.")
    void createLottoNumbersTest() {
        LottoNumbers lottoNumbers = new LottoNumbers(Lists.list(1, 2, 3, 4, 5, 6));
        LottoNumbers otherLottoNumbers = new LottoNumbers(Lists.list(5, 4, 3, 2, 1, 6));

        assertThat(lottoNumbers).isEqualTo(otherLottoNumbers);
    }

    @Test
    @DisplayName("로또 숫자는 중복되면 안된다.")
    void distinctTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.with(1, 2, 3, 4, 5, 5));
    }

    @Test
    @DisplayName("로또 숫자는 6 개 이어야 한디.")
    void sizeTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.with(1, 2, 3, 4, 5));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.with(1, 2, 3, 4, 5, 6, 7));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 2 3 4 5 6 : 7 8 9 12 24 26 : 0",
            "1 2 3 4 5 6 : 8 42 6 12 24 26 : 1",
            "1 2 3 4 5 6 : 7 4 2 12 24 26 : 2",
            "1 2 3 4 5 6 : 8 2 6 4 24 26 : 3",
            "1 2 3 4 5 6 : 7 4 6 12 5 1 : 4",
            "1 2 3 4 5 6 : 6 4 3 1 5 26 : 5",
            "1 2 3 4 5 6 : 1 2 3 4 5 6 : 6"
    }, delimiter = ':')
    @DisplayName("당청 번호와 일치하는 숫자의 개수를 올바르게 리턴해야한다")
    void matchTest(String winning, String lotto, int matchCount) {
        LottoNumbers winningNums = new LottoNumbers(mapToIntList(winning));
        LottoNumbers lottoNumbers = new LottoNumbers(mapToIntList(lotto));

        assertThat(lottoNumbers.match(winningNums)).isEqualTo(matchCount);
    }

    private List<Integer> mapToIntList(String input) {
        return Stream.of(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
