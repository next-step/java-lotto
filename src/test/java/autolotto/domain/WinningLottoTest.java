package autolotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto(LottoNumbers.of(Set.of(1,2,3,4,5,6)), LottoNumber.of(7));
    }

    @ParameterizedTest
    @ValueSource(ints = {3})
    void numberGiven_ReturnContainResult(int compare) {
        assertThat(winningLotto.contains(LottoNumber.of(compare))).isTrue();
    }

    @Test
    void checkBonus(String number) {
        assertThat(winningLotto.checkBonus(LottoNumbers.of(Set.of(1,2,3,4,5,6)))).isFalse();
        assertThat(winningLotto.checkBonus(LottoNumbers.of(Set.of(1,2,3,4,5,7)))).isTrue();
    }
}
