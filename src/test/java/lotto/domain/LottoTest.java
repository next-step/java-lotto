package lotto.domain;

import org.junit.jupiter.api.Test;

import static calculator.domain.InputValueProcessing.calculateInputValue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    void 로또_개수_구하기() {
        assertThat(new Lotto(14000).getLottoCount()).isEqualTo(14);
    }

}
