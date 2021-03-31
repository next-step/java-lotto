package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    Lotto lotto;

    @Test
    @DisplayName("14개를 전달하면 14개를 줘야한다")
    void makeLottoNumbers() {
        lotto.buy(14);
        assertThat(lotto.auto().size())
                .isEqualTo(14);
    }

    @Test
    @DisplayName("자동, 수동갯수테스트")
    void manualAutoCount() {
        lotto.buyManual(4, 20);
        assertThat(lotto.auto().size())
                .isEqualTo(16);
        assertThat(lotto.manual().size())
                .isEqualTo(4);
    }

    @BeforeEach
    void init() {
        lotto = new Lotto();
    }
}
