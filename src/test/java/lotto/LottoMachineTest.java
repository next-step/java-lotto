package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoMachineTest {

    @Test
    @DisplayName("구입한 금액 확인 가능")
    void buyLottoPrice() {
        LottoMachine lottoMachine = new LottoMachine(10000);

        List<LottoTicket> lottoTickets = lottoMachine.getLottoTickets();

        assertThat(lottoTickets).hasSize(10);
    }

    @Test
    @DisplayName("로또 구입 금액 정합성 체크")
    void validLottoPrice() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // when
                    LottoMachine lottoMachine = new LottoMachine(500);
                }).withMessageContaining("구매 금액 에러");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // when
                    LottoMachine lottoMachine = new LottoMachine(1500);
                }).withMessageContaining("구매 금액 에러");
    }

    @Test
    @DisplayName("로또 당첨번호를 저장 할 수 있다.")
    void saveWinningLottoNumber() {
        LottoMachine lottoMachine = new LottoMachine(1000);

        int testBounsNumber = 7;
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(new LottoTicket("1,2,3,4,5,6"), testBounsNumber);

        lottoMachine.saveWinningNumber(winningLottoTicket);

        WinningLottoTicket actualWinnerNumber = lottoMachine.getWinningLottoNumber();

        assertThat(actualWinnerNumber.getWinningLottoNumbers())
                .hasSize(6)
                .contains(1, 2, 3, 4, 5, 6);

        assertThat(actualWinnerNumber.getBounsNumber()).isEqualTo(testBounsNumber);
    }

    @Test
    @DisplayName("당첨통계를 낼 수 있다. 금액편")
    void statisticsAmount() {
        
        List<LottoTicket> lottoTickets = new ArrayList<>();

        int rottoPrice = 1000;

        lottoTickets.add(new LottoTicket("1,2,7,8,9,10")); // 미당첨
        lottoTickets.add(new LottoTicket("10,11,12,13,14,15")); // 미당첨
        lottoTickets.add(new LottoTicket("1,2,3,7,8,9")); // 5등  5000월
        lottoTickets.add(new LottoTicket("1,2,3,4,8,9")); // 4등  50000
        lottoTickets.add(new LottoTicket("1,2,3,4,5,9")); // 3등  1500000
        lottoTickets.add(new LottoTicket("1,2,3,4,5,7")); // 2등  30000000
        lottoTickets.add(new LottoTicket("1,2,3,4,5,6")); // 1등  2000000000

        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(new LottoTicket("1,2,3,4,5,6"), 7);

        // 모든 등수
        long estimatedAmount = Arrays.stream(LottoRank.values())
                .mapToInt(value -> value.winningAmount)
                .sum();

        LottoMachine lottoMachine = new LottoMachine(rottoPrice * lottoTickets.size(), lottoTickets);

        lottoMachine.saveWinningNumber(winningLottoTicket);

        assertThat(lottoMachine.getamountStatistics());
    }

    @Test
    @DisplayName("당첨통계를 낼 수 있다. 수익률편")
    void aggregationOfReturns() {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        int rottoPrice = 1000;

        lottoTickets.add(new LottoTicket("1,2,7,8,9,10")); // 미당첨
        lottoTickets.add(new LottoTicket("10,11,12,13,14,15")); // 미당첨
        lottoTickets.add(new LottoTicket("1,2,3,7,8,9")); // 5등  5000월
        lottoTickets.add(new LottoTicket("1,2,3,4,8,9")); // 4등  50000
        lottoTickets.add(new LottoTicket("1,2,3,4,5,9")); // 3등  1500000
        lottoTickets.add(new LottoTicket("1,2,3,4,5,7")); // 2등  30000000
        lottoTickets.add(new LottoTicket("1,2,3,4,5,6")); // 1등  2000000000

        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(new LottoTicket("1,2,3,4,5,6"), 7);

        // 모든 등수
        BigDecimal estimatedAmount = new BigDecimal(Arrays.stream(LottoRank.values())
                .mapToInt(value -> value.winningAmount)
                .sum());

        LottoMachine lottoMachine = new LottoMachine(rottoPrice * lottoTickets.size(), lottoTickets);

        lottoMachine.saveWinningNumber(winningLottoTicket);

        BigDecimal divisor = new BigDecimal(rottoPrice * lottoTickets.size());

        assertThat(lottoMachine.getAggregationOfReturns())
                .isEqualTo(estimatedAmount.divide(divisor, 3, RoundingMode.HALF_UP).toString());

    }

    


}
