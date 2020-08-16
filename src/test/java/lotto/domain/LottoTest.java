package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void create() {
        int purchaseNumber = 5;
        Lotto lotto = Lotto.of(5);

        assertThat(lotto.number()).isEqualTo(purchaseNumber);
    }
}
