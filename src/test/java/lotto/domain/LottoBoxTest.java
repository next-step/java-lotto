package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoBoxTest {

    private Lotto firstLotto;
    private Lotto secondLotto;
    private Lotto bonusLotto;
    private Lotto thirdLotto;
    private Lotto fourthLotto;
    private Lotto noneLotto;

    private final int BONUS_NUMBER = 45;

    @BeforeEach
    public void setUp() {
        firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        secondLotto = new Lotto(List.of(10, 2, 3, 4, 5, 6));
        bonusLotto = new Lotto(List.of(BONUS_NUMBER, 2, 3, 4, 5, 6));
        thirdLotto = new Lotto(List.of(10, 20, 3, 4, 5, 6));
        fourthLotto = new Lotto(List.of(10, 20, 30, 4, 5, 6));
        noneLotto = new Lotto(List.of(10, 20, 30, 40, 5, 6));
    }

    @Test
    void 로또_1등_체크() {
        LottoBox lottoBox = new LottoBox(List.of(
                firstLotto,
                firstLotto,
                firstLotto
        ));
        Lotto correctLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.of(correctLotto, LottoBall.from(10));
        List<WinningResult> winningResults = lottoBox.retrieveCorrectNum(winningLotto);
        assertThat(winningResults)
                .containsExactly(new WinningResult(6), new WinningResult(6), new WinningResult(6));
    }

    @Test
    void 로또_모든_등수_갯수_맞추기() {
        LottoBox lottoBox = new LottoBox(List.of(
                firstLotto,
                secondLotto,
                bonusLotto,
                thirdLotto,
                fourthLotto,
                noneLotto
        ));
        Lotto correctLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.of(correctLotto, LottoBall.from(BONUS_NUMBER));
        List<WinningResult> winningResults = lottoBox.retrieveCorrectNum(winningLotto);
        assertThat(winningResults)
                .containsExactly(
                        new WinningResult(6),
                        new WinningResult(5),
                        new WinningResult(5, true),
                        new WinningResult(4),
                        new WinningResult(3),
                        new WinningResult(2)
                );
    }
}