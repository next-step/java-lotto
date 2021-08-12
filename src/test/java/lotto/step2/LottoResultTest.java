package lotto.step2;

import lotto.step2.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    LottoResult lottoResult;
    List<LottoNumber> winningNumber;

    @BeforeEach
    void init() {
        winningNumber = new ArrayList<>();
        winningNumber.add(new LottoNumber(1));
        winningNumber.add(new LottoNumber(2));
        winningNumber.add(new LottoNumber(3));
        winningNumber.add(new LottoNumber(4));
        winningNumber.add(new LottoNumber(5));
        winningNumber.add(new LottoNumber(6));
        lottoResult = new LottoResult(LottoTicket.generateWinningNumber(winningNumber));
    }

    @Test
    @DisplayName("로또 당첨 번호와 2개 번호 일치")
    void matchTwoNumber() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(12));
        lottoNumbers.add(new LottoNumber(14));
        lottoNumbers.add(new LottoNumber(15));
        lottoNumbers.add(new LottoNumber(16));
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        lottoResult.checkLottoTicket(lottoTicket);
        assertThat(lottoResult.getLottoResult().getOrDefault(WinningRank.FOURTH_PLACE, 0)).isEqualTo(0);
    }

    @Test
    @DisplayName("로또 당첨 번호와 3개 번호 일치")
    void matchThreeNumber() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(40));
        lottoNumbers.add(new LottoNumber(15));
        lottoNumbers.add(new LottoNumber(16));
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        lottoResult.checkLottoTicket(lottoTicket);
        assertThat(lottoResult.getLottoResult().getOrDefault(WinningRank.FOURTH_PLACE, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 당첨 번호와 4개 번호 일치")
    void matchFourNumber() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(15));
        lottoNumbers.add(new LottoNumber(16));
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        lottoResult.checkLottoTicket(lottoTicket);
        assertThat(lottoResult.getLottoResult().getOrDefault(WinningRank.THIRD_PLACE, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 당첨 번호와 5개 번호 일치")
    void matchFiveNumber() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(16));
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        lottoResult.checkLottoTicket(lottoTicket);
        assertThat(lottoResult.getLottoResult().getOrDefault(WinningRank.SECOND_PLACE, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 당첨 번호와 6개 번호 일치")
    void matchSixNumber() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(6));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(1));
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        lottoResult.checkLottoTicket(lottoTicket);
        assertThat(lottoResult.getLottoResult().getOrDefault(WinningRank.FIRST_PLACE, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("3개 일치 수익률 확인")
    void calculateStatistics() {
        int price = 5000;
        LottoTicket ticket = new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(11), new LottoNumber(22), new LottoNumber(33)));
        lottoResult.checkLottoTicket(ticket);
        assertThat(lottoResult.calculateStatistics(price)).isEqualTo(1.00);
    }

    @Test
    @DisplayName("4개 일치 수익률 확인")
    void calculateStatistics3() {
        int price = 5000;
        LottoTicket ticket = new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(15), new LottoNumber(33)));
        lottoResult.checkLottoTicket(ticket);
        assertThat(lottoResult.calculateStatistics(price)).isEqualTo(10.00);
    }

    @Test
    @DisplayName("5개 일치 수익률 확인")
    void calculateStatistics2() {
        int price = 5000;
        LottoTicket ticket = new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(33)));
        lottoResult.checkLottoTicket(ticket);
        assertThat(lottoResult.calculateStatistics(price)).isEqualTo(300.00);
    }

    @Test
    @DisplayName("6개 일치 수익률 확인")
    void calculateStatistics4() {
        int price = 5000;
        LottoTicket ticket = new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        lottoResult.checkLottoTicket(ticket);
        assertThat(lottoResult.calculateStatistics(price)).isEqualTo(400000.00);
    }

    @Test
    @DisplayName("다중 당첨 수익률 확인")
    void calculateStatistics5() {
        int price = 5000;
        LottoTicket ticket1 = new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(14), new LottoNumber(15), new LottoNumber(16)));
        LottoTicket ticket2 = new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(11), new LottoNumber(23)));
        lottoResult.checkLottoTicket(ticket1);
        lottoResult.checkLottoTicket(ticket2);
        assertThat(lottoResult.calculateStatistics(price)).isEqualTo(11.00);
    }

    @Test
    @DisplayName("다중 당첨 수익률 확인2")
    void calculateStatistics7() {
        int price = 5000;
        LottoTicket ticket1 = new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(14), new LottoNumber(35), new LottoNumber(26)));
        LottoTicket ticket2 = new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(24), new LottoNumber(35), new LottoNumber(26)));
        lottoResult.checkLottoTicket(ticket1);
        lottoResult.checkLottoTicket(ticket2);
        assertThat(lottoResult.calculateStatistics(price)).isEqualTo(2.00);
    }

    @Test
    @DisplayName("1등에 2번 당첨 되면 2000000000 * 2이 아니라 당첨금의 2분의1을 2번 받는 것이다. ")
    void calculateStatistics8() {
        int price = 5000;
        LottoTicket ticket1 = new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        LottoTicket ticket2 = new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        lottoResult.checkLottoTicket(ticket1);
        lottoResult.checkLottoTicket(ticket2);
        assertThat(lottoResult.calculateStatistics(price)).isEqualTo(400000.00);
    }


}