package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoNumberTest {

    @DisplayName("로또번호는 1이상 45이하 여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 46})
    void invalid_로또번호(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(number));
    }
}

