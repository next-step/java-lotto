package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("입력을 바탕으로 로또를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "2,3,4,5,6,7"})
    void createLottoTest(String numbers) {
        assertThat(new Lotto(numbers))
                .isEqualTo(new Lotto(numbers));
    }

    @DisplayName("두 로또를 비교해서 일치하는 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = "1, 2, 3, 4, 5, 6: 3, 4, 5, 6, 7, 8:4", delimiter = ':')
    void countMatchNumberTest(String lotto1, String lotto2, int matchCount) {
        assertThat(new Lotto(lotto1).countMatchNumber(new Lotto(lotto2)))
                .isEqualTo(matchCount);
    }
}
