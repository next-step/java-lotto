package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void test_get_winners() {
        LottoNumbers numbers1 = LottoNumbers.of(1, 2, 3, 4, 5, 6);
        LottoNumbers numbers2 = LottoNumbers.of(1, 2, 3, 4, 5, 7);
        Lotto round = new Lotto(List.of(numbers1, numbers2));

        WinningLotto winningLotto = new WinningLotto(LottoNumbers.of(1, 2, 3, 4, 5, 6), LottoNumber.of(7));

        assertThat(round.match(winningLotto)).contains(LottoResult.FIRST, LottoResult.SECOND);
    }
}
