package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoManualTest {
    @Test
    void lottoCreateSet() {
        LottoManual lottoManual = LottoManual.of("1, 2, 3, 4, 5, 6");
        assertThat(lottoManual.getLotto().size()).isEqualTo(6);
    }

    @Test
    void lottoCreateList() {
        LottoManual lottoManual = LottoManual.of("1, 2, 3, 4, 5, 6");
        assertThat(lottoManual.getLotto().size()).isEqualTo(6);
    }

    @Test
    void lottoCount6Exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoManual.of("1, 2, 3, 4, 5, 6,7"));
    }

    @Test
    void match6() {
        LottoManual lottoManual = LottoManual.of("1, 2, 3, 4, 5, 6");
        LottoManual winningLotto = LottoManual.of("1, 2, 3, 4, 5, 6");
        int mathchCount = lottoManual.match(winningLotto);
        assertThat(mathchCount).isEqualTo(6);
    }

    @Test
    void contains() {
        LottoManual lottoManual = LottoManual.of("1, 2, 3, 4, 5, 6");
        boolean result = lottoManual.contains(LottoNumber.of(1));
        assertThat(result).isTrue();

        result = lottoManual.contains(LottoNumber.of(7));
        assertThat(result).isFalse();
    }
}
