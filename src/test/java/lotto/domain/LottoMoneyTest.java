package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoMoneyTest {

    private LottoMoney lottoMoney;

    @Test
    void validateMoney() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoMoney(500);
        });
    }
}
