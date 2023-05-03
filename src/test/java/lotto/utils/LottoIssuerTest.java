package lotto.utils;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoIssuerTest {

    @Test
    void issueLottos() {
        List<Lotto> lotto = LottoIssuer.issueLottos(14);
        assertThat(lotto.size()).isEqualTo(14);
    }
}
