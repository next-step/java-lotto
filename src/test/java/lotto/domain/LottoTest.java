package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("입력을 바탕으로 로또를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "2,3,4,5,6,7"})
    void createLottoTest(String numbers) {
        assertThat(new Lotto(numbers))
                .isEqualTo(new Lotto(numbers));
    }

    @DisplayName("숫자를 다른 순서로 입력해도 구성하는 번호가 같다면 같은 로또가 생성된다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:2,3,1,4,6,5", "2,3,4,5,6,7:7,6,5,4,3,2"}, delimiter = ':')
    void createLottoTestDifferentOrder(String numbers1, String numbers2) {
        assertThat(new Lotto(numbers1))
                .isEqualTo(new Lotto(numbers2));
    }

    @DisplayName("로또는 중복된 번호를 가질 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,1,1,1,1", "1,2,3,4,5,5"})
    void createLottoDistinctTest(String numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또는 6개의 숫자로 이루어져야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void createLottoLengthTest(String numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("두 로또를 비교해서 일치하는 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = "1, 2, 3, 4, 5, 6: 3, 4, 5, 6, 7, 8:4", delimiter = ':')
    void countMatchNumberTest(String lotto1, String lotto2, int matchCount) {
        assertThat(new Lotto(lotto1).countMatchNumber(new Lotto(lotto2)))
                .isEqualTo(matchCount);
    }
}
