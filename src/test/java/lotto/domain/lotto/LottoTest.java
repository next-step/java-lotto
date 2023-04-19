package lotto.domain.lotto;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    void create() {
        Assertions.assertThat(new Lotto())
                .extracting("lottoNumbers")
                .isNotNull();
    }
}
