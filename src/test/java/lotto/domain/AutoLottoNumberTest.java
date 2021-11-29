package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AutoLottoNumberTest {

    @Test
    @DisplayName("생성 성공")
    void create() {
        assertThat(new AutoLottoNumber().createLottoNumber().size()).isEqualTo(6);
    }

}
