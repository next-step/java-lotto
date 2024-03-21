package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 로또_리스트() {
        assertThat(new Lotto().createLottoNumbers()).hasSize(6);
    }

    @Test
    void 로또_리스트_여러개() {
        assertThat(new Lotto().createLottoList(10)).hasSize(10);
    }

}
