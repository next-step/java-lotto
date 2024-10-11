package lotto.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {

    @DisplayName("로또 번호가 6개가 아니면 예외로 처리한다.")
    @Test
    void fromSizeException() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoNumbers(List.of(1))
        );
    }

    @DisplayName("중복된 로또 번호가 있으면 예외로 처리한다.")
    @Test
    void fromDuplicateNumberException() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoNumbers(List.of(1, 1, 2, 3, 4, 5))
        );
    }

    @DisplayName("0이하, 46이상의 수를 로또번호로 사용하면 예외로 처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void InvalidLottoNumberException(int invalidLottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoNumbers(List.of(1, 2, 3, 4, 5, invalidLottoNumber))
        );
    }

    @DisplayName("로또에서 특정 번호가 있는지 확인할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void match(int number) {
        LottoNumbers lotto = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.match(number)).isTrue();
    }

}
