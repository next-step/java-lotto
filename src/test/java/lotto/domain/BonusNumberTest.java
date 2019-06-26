package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BonusNumberTest {
    private BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        bonusNumber = new BonusNumber(7);
    }

    @Test
    void 생성자로인스턴스변수set() {
        assertThat(bonusNumber.getNumber()).isEqualTo(7);
    }
}
