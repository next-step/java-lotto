package lotto.domains;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import lotto.exceptions.InvalidLottoNumberException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void Given_InRangeNumber_When_CreateLottoNumber_Then_Created(int number) {
        assertThatNoException().isThrownBy(() -> LottoNumber.of(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void Given_OutRangeNumber_When_CreateLottoNumber_Then_Fail(int number) {
        assertThatThrownBy(() -> LottoNumber.of(number)).isInstanceOf(InvalidLottoNumberException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "45"})
    void testSuccessCreateLottoNumberByString(String string) {
        assertThatNoException().isThrownBy(() -> LottoNumber.of(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void testFailCreateLottoNumberByString(String string) {
        assertThatThrownBy(() -> LottoNumber.of(string)).isInstanceOf(InvalidLottoNumberException.class);
    }
}
