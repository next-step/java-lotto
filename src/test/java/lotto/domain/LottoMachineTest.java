package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    @DisplayName("구입한 갯수를 알 수 있다.")
    void lottoCount() {
        LottoMachine lottoMachine = new LottoMachine(10000);

        assertThat(lottoMachine.lottoTotalCount()).isEqualTo(10);
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
                .map()
                .contains(1, 2, 3, 4, 5, 6);

        assertThat(actualWinnerNumber.getBounsNumber()).isEqualTo(LottoNumber.getLottoNumber(7));
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

    @Test
    @DisplayName("당첨번호가 없다면 통계 에러")
    void vaildStatistics() {

        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> {
                    // when
                    LottoMachine lottoMachine = new LottoMachine(5000);


                    lottoMachine.getamountStatistics();

                }).withMessageContaining("당첨번호");

        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> {
                    // when
                    LottoMachine lottoMachine = new LottoMachine(5000);

                    lottoMachine.getAggregationOfReturns();

                }).withMessageContaining("당첨번호");

    }


    @Test
    @DisplayName("로또 당참된 갯수 리턴 확인")
    public void lottoRankMatchTest() {

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

        LottoMachine lottoMachine = new LottoMachine(rottoPrice * lottoTickets.size(), lottoTickets);

        lottoMachine.saveWinningNumber(winningLottoTicket);

        assertThat(lottoMachine.lottoRankMatchCount(LottoRank.FIVE_PLACE)).isEqualTo(1);
        assertThat(lottoMachine.lottoRankMatchCount(LottoRank.FOUR_PLACE)).isEqualTo(1);
        assertThat(lottoMachine.lottoRankMatchCount(LottoRank.THREE_PLACE)).isEqualTo(1);
        assertThat(lottoMachine.lottoRankMatchCount(LottoRank.TWO_PLACE)).isEqualTo(1);
        assertThat(lottoMachine.lottoRankMatchCount(LottoRank.ONE_PLACE)).isEqualTo(1);
    }

    @DisplayName("수동 로또 정합성 체크")
    @Test
    void vaildManualPurchaseLotto() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {

                    List<String> lottos = List.of("1,2,3,4,5,6", "4,5,6,7,8,9");

                    LottoMachine lottoMachine = new LottoMachine(5000, lottos, 3);

                }).withMessageContaining("수동 로또 갯수 에러");
    }

    @DisplayName("수동로또 구매 테스트")
    @Test
    void manualPurchaseLottos() {

        List<String> lottos = List.of("1,2,3,4,5,6", "4,5,6,7,8,9");

        LottoMachine lottoMachine = new LottoMachine(5000, lottos, 2);

        int manualPurchaseLottsCount = lottoMachine.getManualPurchaseCount();
        List<LottoTicket> lottoTickets = lottoMachine.getLottoTickets();

        assertThat(manualPurchaseLottsCount).isEqualTo(2);
        assertThat(lottoTickets).hasSize(5);

    }
}
