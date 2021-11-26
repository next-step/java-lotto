package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
public class LottoTest {

    @Test
    @DisplayName("로또 자동 생성")
    void create() {
        Lotto byAuto = new Lotto(LottoNumber.createNonDuplicated());
        assertThat(byAuto.getNumbers().size()).isEqualTo(6);
    }
}
