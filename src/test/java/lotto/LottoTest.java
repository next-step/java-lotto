package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    Lotto lotto;

    @Test
    @DisplayName("14개를 전달하면 14개를 줘야한다")
    void makeLottoNumbers() {
        assertThat(lotto.lotto(14).size())
                .isEqualTo(14);
    }

    @BeforeEach
    void init() {
        lotto = new Lotto();
    }
}
