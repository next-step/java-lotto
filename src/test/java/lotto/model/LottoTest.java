package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    WinnerNumbers winnerNumbers;
    Lotto lotto;

    @BeforeEach
    void setUp() {
        winnerNumbers = new WinnerNumbers(Set.of(1, 2, 3, 4, 5, 6));
        lotto = new Lotto(Set.of(1, 3, 5, 6, 7, 8));
    }

    @Test
    @DisplayName("로또 한장과 당첨번호가 count만큼 일치하면 1을 리턴한다.")
    void test1() throws Exception {
        int correctCount = 4;
        assertThat(lotto.match(winnerNumbers, correctCount)).isEqualTo(1);
    }
    @Test
    @DisplayName("로또 한장과 당첨번호가 count만큼 일치하지 않으면 0을 리턴")
    void test2() throws Exception {
        int correctCount = 6;
        assertThat(lotto.match(winnerNumbers, correctCount)).isEqualTo(0);
    }
}