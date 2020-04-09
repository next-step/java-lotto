package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    private LottoNumber lottoNumber;

    @BeforeEach
    public void setup() {
        lottoNumber = LottoNumber.of(1);
    }

    @Test
    public void of() {
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(1));
    }

    @Test
    public void stringOf() {
        assertThat(lottoNumber).isEqualTo(LottoNumber.of("1"));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    public void invalidNumberThrowException(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoNumber = LottoNumber.of(number);
        }).withMessage("로또 번호는 1부터 45까지만 가능합니다.");
    }
}
