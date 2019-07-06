package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    @Test
    void lottoCreateSet() {
        Lotto lotto = Lotto.of(Set.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getLotto().size()).isEqualTo(6);
    }

    @Test
    void lottoCreateList() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getLotto().size()).isEqualTo(6);
    }

    @Test
    void lottoCount6Exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.of(Arrays.asList(1, 2, 3, 4, 5));
        });
    }
}
