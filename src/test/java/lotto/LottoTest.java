package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void autoGenerateLottoNumberTest() {
        assertThat(new Lotto(true).getLottoNumbers()).hasSize(6);
    }

}
