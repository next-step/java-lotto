package lotto.step2;

import lotto.step2.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    LottoTicket winningNumber;

    @BeforeEach
    void init() {
        winningNumber = new LottoTicket(new HashSet<>
                (Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6))
                ));
    }

    @Test
    @DisplayName("당첨 번호와 2개 일치")
    void matchTwoCount() {
        Lotto lotto = new Lotto(
                Arrays.asList(
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(13), new LottoNumber(14), new LottoNumber(15), new LottoNumber(16))))
                ));
        LottoResult lottoResult = lotto.matchLottoTicket(winningNumber);
        assertThat(lottoResult.getLottoResult().getOrDefault(WinningRank.NONE_PLACE, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 번호와 3개 일치")
    void matchThreeCount() {
        Lotto lotto = new Lotto(
                Arrays.asList(
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(14), new LottoNumber(13), new LottoNumber(16))))
                ));
        LottoResult lottoResult = lotto.matchLottoTicket(winningNumber);
        assertThat(lottoResult.getLottoResult().getOrDefault(WinningRank.FOURTH_PLACE, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 번호와 4개 일치")
    void matchFourCount() {
        Lotto lotto = new Lotto(
                Arrays.asList(
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(15), new LottoNumber(16))))
                ));
        LottoResult lottoResult = lotto.matchLottoTicket(winningNumber);
        assertThat(lottoResult.getLottoResult().getOrDefault(WinningRank.THIRD_PLACE, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 번호와 5개 일치")
    void matchFiveCount() {
        Lotto lotto = new Lotto(
                Arrays.asList(
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(16))))
                ));
        LottoResult lottoResult = lotto.matchLottoTicket(winningNumber);
        assertThat(lottoResult.getLottoResult().getOrDefault(WinningRank.SECOND_PLACE, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 번호와 6개 일치")
    void matchSixCount() {
        Lotto lotto = new Lotto(
                Arrays.asList(
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))))
                ));
        LottoResult lottoResult = lotto.matchLottoTicket(winningNumber);
        assertThat(lottoResult.getLottoResult().getOrDefault(WinningRank.FIRST_PLACE, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 2개 구입 3등 1개 , 4등 1개 ")
    void buyLotto() {
        int money = 2000;
        Lotto lotto = new Lotto(
                Arrays.asList(
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(24), new LottoNumber(14), new LottoNumber(3), new LottoNumber(16)))), //4등
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(11), new LottoNumber(12), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))))//3등
                ));
        LottoResult lottoResult = lotto.matchLottoTicket(winningNumber);
        assertThat(lottoResult.calculateStatistics(money)).isEqualTo("27.50");
    }

    @Test
    @DisplayName("로또 3개 구입 꽝 1개 ,2등 2개 1등 1개")
    void buyLotto2() {
        int money = 4000;
        Lotto lotto = new Lotto(
                Arrays.asList(
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(11), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(6), new LottoNumber(5)))), // 2등
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(1), new LottoNumber(12), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))), // 2등
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(6), new LottoNumber(5)))), // 1등
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(11), new LottoNumber(22), new LottoNumber(31), new LottoNumber(14), new LottoNumber(26), new LottoNumber(35)))) // 꽝
                ));
        LottoResult lottoResult = lotto.matchLottoTicket(winningNumber);
        assertThat(lottoResult.calculateStatistics(money)).isEqualTo("500750.00");

    }

    @Test
    @DisplayName("로또 5개 구입 꽝 2개 ,2등 2개 4등 1개")
    void buyLotto3() {
        int money = 5000;
        Lotto lotto = new Lotto(
                Arrays.asList(
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(24), new LottoNumber(12), new LottoNumber(23), new LottoNumber(14), new LottoNumber(16), new LottoNumber(15)))), // 꽝
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(11), new LottoNumber(23), new LottoNumber(13), new LottoNumber(41), new LottoNumber(36), new LottoNumber(5)))), // 꽝
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(1), new LottoNumber(3), new LottoNumber(13), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))), // 2등
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(14), new LottoNumber(6), new LottoNumber(5)))), // 2등
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(11), new LottoNumber(22), new LottoNumber(3), new LottoNumber(14), new LottoNumber(5), new LottoNumber(6)))) // 4등
                ));
        LottoResult lottoResult = lotto.matchLottoTicket(winningNumber);
        assertThat(lottoResult.calculateStatistics(money)).isEqualTo("601.00");
    }

    @Test
    @DisplayName("로또 5개 구입 꽝 1개 1등 4개")
    void buyLotto4() {
        int money = 5000;
        Lotto lotto = new Lotto(
                Arrays.asList(
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(2), new LottoNumber(1), new LottoNumber(4), new LottoNumber(3), new LottoNumber(5), new LottoNumber(6)))), // 1등
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(3), new LottoNumber(4), new LottoNumber(2), new LottoNumber(1), new LottoNumber(5), new LottoNumber(6)))), // 1등
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(1), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(2)))), // 1등
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(6), new LottoNumber(5)))), // 1등
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(11), new LottoNumber(22), new LottoNumber(13), new LottoNumber(14), new LottoNumber(25), new LottoNumber(16)))) // 꽝
                ));
        LottoResult lottoResult = lotto.matchLottoTicket(winningNumber);
        assertThat(lottoResult.calculateStatistics(money)).isEqualTo("400000.00");
    }

    @Test
    @DisplayName("로또 3개 구입 1등 3개")
    void buyLotto5() {
        int money = 3000;
        Lotto lotto = new Lotto(
                Arrays.asList(
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(2), new LottoNumber(1), new LottoNumber(4), new LottoNumber(3), new LottoNumber(5), new LottoNumber(6)))), // 1등
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(3), new LottoNumber(4), new LottoNumber(2), new LottoNumber(1), new LottoNumber(5), new LottoNumber(6)))), // 1등
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(1), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(2)))) // 1등
                ));
        LottoResult lottoResult = lotto.matchLottoTicket(winningNumber);
        assertThat(lottoResult.calculateStatistics(money)).isEqualTo("666666.67");
    }

    @Test
    @DisplayName("로또 2개 구입 1등 2개")
    void buyLotto6() {
        int money = 2000;
        Lotto lotto = new Lotto(
                Arrays.asList(
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(2), new LottoNumber(1), new LottoNumber(4), new LottoNumber(3), new LottoNumber(5), new LottoNumber(6)))), // 1등
                        new LottoTicket(new HashSet<>(Arrays.asList(new LottoNumber(3), new LottoNumber(4), new LottoNumber(2), new LottoNumber(1), new LottoNumber(5), new LottoNumber(6)))) // 1등
                ));
        LottoResult lottoResult = lotto.matchLottoTicket(winningNumber);
        assertThat(lottoResult.calculateStatistics(money)).isEqualTo("1000000.00");
    }
}