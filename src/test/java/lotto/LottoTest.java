package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    Lotto lotto = new Lotto();

    @Test
    void lottoNum() {
        List lottoNum = lotto.lottoNum();
        assertThat(lottoNum).isNotNull();
        assertThat(lottoNum.size()).isEqualTo(6);
    }

    @Test
    void countWin3() {
        List<Integer> lottoNum = lotto.lottoNum();
        int[] win3 = new int[6];
        win3[0] = lottoNum.get(0);
        win3[1] = lottoNum.get(1);
        win3[2] = lottoNum.get(2);
        win3[3] = lottoNum.get(3) + 100;
        win3[4] = lottoNum.get(4) + 100;
        win3[5] = lottoNum.get(5) + 100;
        assertThat(lotto.countWin(win3)).isEqualTo(3);
    }

    @Test
    void countWin4() {
        List<Integer> lottoNum = lotto.lottoNum();
        int[] win = new int[6];
        win[0] = lottoNum.get(0);
        win[1] = lottoNum.get(1);
        win[2] = lottoNum.get(2);
        win[3] = lottoNum.get(3);
        win[4] = lottoNum.get(4) + 100;
        win[5] = lottoNum.get(5) + 100;
        assertThat(lotto.countWin(win)).isEqualTo(4);
    }

    @Test
    void countWin5() {
        List<Integer> lottoNum = lotto.lottoNum();
        int[] win = new int[6];
        win[0] = lottoNum.get(0);
        win[1] = lottoNum.get(1);
        win[2] = lottoNum.get(2);
        win[3] = lottoNum.get(3);
        win[4] = lottoNum.get(4);
        win[5] = lottoNum.get(5) + 100;
        assertThat(lotto.countWin(win)).isEqualTo(5);
    }

    @Test
    void countWin6() {
        List<Integer> lottoNum = lotto.lottoNum();
        int[] win = new int[6];
        win[0] = lottoNum.get(0);
        win[1] = lottoNum.get(1);
        win[2] = lottoNum.get(2);
        win[3] = lottoNum.get(3);
        win[4] = lottoNum.get(4);
        win[5] = lottoNum.get(5);
        assertThat(lotto.countWin(win)).isEqualTo(6);
    }

}