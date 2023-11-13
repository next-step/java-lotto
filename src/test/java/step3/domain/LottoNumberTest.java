package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    @DisplayName("로또번호 생성")
    void create() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(lottoNumber.number()).isEqualTo(1);
    }
}
