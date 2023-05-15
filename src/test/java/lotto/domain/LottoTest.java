package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("로또 번호는 6개여야 한다")
    void lotto_must_be_size_SIX() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertEquals(6, lotto.getLottoNumbers().size());
    }

    @Test
    @DisplayName("로또 번호는 1부터 45사이여야 한다")
    void lotto_number_must_be_between_1_and_45() {
        assertThrows(IllegalArgumentException.class, () -> new Lotto(Arrays.asList(1,2,3,4,5,46)));
    }

    @Test
    @DisplayName("로또 번호는 중복될 수 없다")
    void lotto_number_must_not_be_duplicated() {
        assertThrows(IllegalArgumentException.class, () -> new Lotto(Arrays.asList(1,2,3,4,5,5)));
    }

    @Test
    @DisplayName("CountMathTest")
    void count_match_test() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,7));
        assertEquals(5, lotto.countMatch(winningLotto.getLottoNumbers()));
    }

    @Test
    @DisplayName("보너스 번호 테스트")
    void bonus_number_test() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertTrue(lotto.hasBonusNumber(6));
    }

}