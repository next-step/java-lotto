package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void 로또_오토_체크() {
        assertThat(new Lotto().getLottoNumbers()).hasSize(6);
    }
}
