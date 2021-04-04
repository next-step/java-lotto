package lotto.controller;

import lotto.controller.dto.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoControllerTest {

    @Test
    @DisplayName("로또 구입 테스트 자동 Only")
    void purchaseLotto_AutoOnly() {
        // given
        LottoTicketPurchaseRequest request = new LottoTicketPurchaseRequest(14000, new ArrayList<>());
        LottoPurchaseController controller = new LottoPurchaseController();

        // when
        LottoTicketPurchaseResponse response = controller.purchaseLottoTicket(request);

        // then
        assertThat(14).isEqualTo(response.getAutoPurchaseCount());
        assertThat(0).isEqualTo(response.getManualPurchaseCount());
        assertThat(14).isEqualTo(response.getLottoNumberList().size());
    }

    @Test
    @DisplayName("로또 구입 테스트 수동 Only")
    void purchaseLotto_ManualOnly() {
        // given
        List<String> manualLottoPurchaseNumberList = Arrays.asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7", "3, 4, 5, 6, 7, 8");
        LottoTicketPurchaseRequest request = new LottoTicketPurchaseRequest(3000, manualLottoPurchaseNumberList);
        LottoPurchaseController controller = new LottoPurchaseController();

        // when
        LottoTicketPurchaseResponse response = controller.purchaseLottoTicket(request);

        // then
        assertThat(0).isEqualTo(response.getAutoPurchaseCount());
        assertThat(3).isEqualTo(response.getManualPurchaseCount());
        assertThat(3).isEqualTo(response.getLottoNumberList().size());
    }

    @Test
    @DisplayName("로또 구입 테스트")
    void purchaseLotto() {
        // given
        List<String> manualLottoPurchaseNumberList = Arrays.asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7", "3, 4, 5, 6, 7, 8");
        LottoTicketPurchaseRequest request = new LottoTicketPurchaseRequest(5000, manualLottoPurchaseNumberList);
        LottoPurchaseController controller = new LottoPurchaseController();

        // when
        LottoTicketPurchaseResponse response = controller.purchaseLottoTicket(request);

        // then
        assertThat(2).isEqualTo(response.getAutoPurchaseCount());
        assertThat(3).isEqualTo(response.getManualPurchaseCount());
        assertThat(5).isEqualTo(response.getLottoNumberList().size());
    }

    @Test
    @DisplayName("로또 구입 시 로또 한 건의 구성 번호는 모두 달라야 한다.")
    void purchaseLotto_lottoNumber_distinct() {
        // given
        List<String> manualLottoPurchaseNumberList = Arrays.asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7", "3, 4, 5, 6, 7, 8");
        LottoTicketPurchaseRequest request = new LottoTicketPurchaseRequest(14000, manualLottoPurchaseNumberList);
        LottoPurchaseController controller = new LottoPurchaseController();

        // when
        LottoTicketPurchaseResponse response = controller.purchaseLottoTicket(request);

        // then
        for (String lottoNumbers : response.getLottoNumberList()) {
            lottoNumbers = lottoNumbers.substring(1, lottoNumbers.length() - 1);
            long count = Arrays.stream(Arrays.stream(lottoNumbers.split(","))
                    .mapToInt(lottoNumber -> Integer.parseInt(lottoNumber.trim()))
                    .toArray())
                    .distinct()
                    .count();
            assertThat(6).isEqualTo(count);
        }
    }

    @Test
    @DisplayName("당첨결과 조회 - 등수 별 하나씩 당첨")
    void inquiryWin() {
        // given
        LottoWinInquiryController controller = new LottoWinInquiryController();
        List<String> lottoNumberInputList = new ArrayList<>();
        lottoNumberInputList.add("1, 2, 3, 4, 5, 6");
        lottoNumberInputList.add("1, 2, 3, 4, 5, 7");
        lottoNumberInputList.add("1, 2, 3, 4, 7, 8");
        lottoNumberInputList.add("1, 2, 3, 7, 8, 9");
        lottoNumberInputList.add("1, 2, 3, 4, 5, 45");
        WinInquiryRequest winInquiryRequest = new WinInquiryRequest("1, 2, 3, 4, 5, 6", lottoNumberInputList, 45);

        // when
        WinInquiryResponse winInquiryResponse = controller.inquiryWin(winInquiryRequest);

        // then
        for (WinStatistic winStatistic : winInquiryResponse.getWinStatisticList()) {
            assertThat(1).isEqualTo(winStatistic.getMatchLottoCount());
        }
        assertThat(406311.00).isEqualTo(winInquiryResponse.getTotalReturnRate());
    }
}