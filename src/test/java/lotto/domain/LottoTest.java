package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    private Lotto lotto;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(
                new LottoNumbers(1, 3, 5, 7, 19, 41),     // 4개 일치
                new LottoNumbers(1, 3, 6, 8, 20, 30),     // 2개 일치
                new LottoNumbers(2, 4, 6, 8, 10, 12),     // 2개 일치
                new LottoNumbers(6, 7, 8, 9, 10, 11),     // 1개 일치
                new LottoNumbers(1, 6, 8, 9, 20, 21),     // 1개 일치
                new LottoNumbers(10, 17, 18, 19, 20, 31), // 0개 일치
                new LottoNumbers(17, 27, 28, 29, 30, 41), // 0개 일치
                new LottoNumbers(19, 23, 28, 31, 40, 44)  // 0개 일치
        ));

        winningLotto = new WinningLotto(1, 2, 3, 4, 5, 7);
    }

    @Test
    @DisplayName("당첨번호 일치하는 번호 갯수 계산")
    void matchingWinningNumberCount(){

        lotto.match(winningLotto.lastWinningNumbers());

        Map<Integer, Integer> winningCounts = lotto.match(winningLotto.lastWinningNumbers());

        assertThat(winningCounts.get(0)).isEqualTo(3);
        assertThat(winningCounts.get(1)).isEqualTo(2);
        assertThat(winningCounts.get(2)).isEqualTo(2);
        assertThat(winningCounts.get(4)).isEqualTo(1);
    }

}