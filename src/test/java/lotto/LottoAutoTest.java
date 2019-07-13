package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoAutoTest {
    @Test
    void lottoCreateSet() {
        LottoAuto lottoAuto = Lotto.of(Set.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoAuto.getLotto().size()).isEqualTo(6);
    }

    @Test
    void lottoCreateList() {
        LottoAuto lottoAuto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoAuto.getLotto().size()).isEqualTo(6);
    }

    @Test
    void lottoCreateString() {
        assertThat(Lotto.of("1,2,3,4,5,6").getLotto())
                .isEqualTo(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)).getLotto());
    }

    @Test
    void lottoCount6Exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    void match6() {
        LottoAuto lottoAuto = Lotto.of(Set.of(1, 2, 3, 4, 5, 6));
        LottoAuto winningLotto = Lotto.of(Set.of(1, 2, 3, 4, 5, 6));
        int mathchCount = lottoAuto.match(winningLotto);
        assertThat(mathchCount).isEqualTo(6);
    }

    @Test
    void contains() {
        LottoAuto lottoAuto = Lotto.of(Set.of(1, 2, 3, 4, 5, 6));
        boolean result = lottoAuto.contains(LottoNumber.of(1));
        assertThat(result).isTrue();

        result = lottoAuto.contains(LottoNumber.of(7));
        assertThat(result).isFalse();
    }
}
