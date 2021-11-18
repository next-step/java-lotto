package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DollarsTest {

    @DisplayName("1000 미만의 값으로 생성할 수 없다.")
    @ParameterizedTest(name = "[{index}] won: {0}")
    @ValueSource(ints = {-100, 0, 999})
    void create_under1000(int won) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Dollars(won))
                .withMessage(Dollars.ILLEGAL_RANGE_ERROR_MESSAGE);
    }

    @DisplayName("1000으로 나눴을 때 나머지는 버린다.")
    @ParameterizedTest(name = "[{index}] won: {0}")
    @CsvSource(value = {
            "1000, 1",
            "4500, 4"
    })
    void create(int won, int expectedCount) {
        Dollars dollars = new Dollars(won);
        assertThat(dollars.getCount()).isEqualTo(expectedCount);
    }

}
