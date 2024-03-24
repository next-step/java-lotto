package lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void find_matched_number_in_winning_lotto() {
        Lotto winningLotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 7, 8, 9));
        MatchedCount count = winningLotto.countMatchedNumber(lotto);

        assertThat(count).isEqualTo(new MatchedCount(3));
    }

    @Test
    void check_lotto_number_is_contained() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 7, 8, 9));
        LottoNumber number = new LottoNumber(3);

        assertThat(lotto.contains(number)).isTrue();
    }
}