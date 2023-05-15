package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
    @Test
    void create() {
        assertThat(new LottoNumber(1).getNumber()).isEqualTo(1);
        assertThat(new LottoNumber(44).getNumber()).isEqualTo(44);
    }

    @Test
    void 범위벗어날경우_체크() {
        assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(InvalidParameterException.class);
        assertThatThrownBy(() -> new LottoNumber(45)).isInstanceOf(InvalidParameterException.class);
    }
}
