package step2.controller;

import org.junit.jupiter.api.Test;
import step2.domain.Lottos;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoApplicationTest {

    @Test
    void issueLottos() {
        final int numberOfPurchases = 14;
        final Lottos lottos = LottoApplication.issueLottos(numberOfPurchases);
        final int actual = lottos.count();
        final int expected = numberOfPurchases;
        assertThat(actual).isEqualTo(expected);
    }
}
