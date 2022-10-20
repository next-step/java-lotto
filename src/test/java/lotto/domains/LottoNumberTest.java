package lotto.domains;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void Given_InRangeNumber_When_CreateLottoNumber_Then_Created(int number) {
        assertThatNoException().isThrownBy(() -> new LottoNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void Given_OutRangeNumber_When_CreateLottoNumber_Then_Fail(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "45"})
    void testSuccessCreateLottoNumberByString(String string) {
        assertThatNoException().isThrownBy(() -> new LottoNumber(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void testFailCreateLottoNumberByString(String string) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(string));
    }
}
