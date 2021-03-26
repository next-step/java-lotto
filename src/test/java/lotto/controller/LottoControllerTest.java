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
    @DisplayName("로또 구입 테스트")
    void purchaseLotto() {
        // given
        LottoAutoPurchaseRequest request = new LottoAutoPurchaseRequest(14000);
        LottoController lottoController = new LottoController();

        // when
        LottoAutoPurchaseResponse response = lottoController.purchaseLottoAutoTicket(request);

        // then
        assertThat(14).isEqualTo(response.getPurchaseCount());
        assertThat(14).isEqualTo(response.getLottoNumberList().size());
    }

    @Test
    @DisplayName("로또 구입 시 로또 한 건의 구성 번호는 모두 달라야 한다.")
    void purchaseLotto_lottoNumber_distinct() {
        // given
        LottoAutoPurchaseRequest request = new LottoAutoPurchaseRequest(14000);
        LottoController lottoController = new LottoController();

        // when
        LottoAutoPurchaseResponse response = lottoController.purchaseLottoAutoTicket(request);

        // then
        for (String lottoNumbers : response.getLottoNumberList()) {
            lottoNumbers = lottoNumbers.substring(1, lottoNumbers.length()-1);
            long count = Arrays.stream(Arrays.stream(lottoNumbers.split(","))
                                .mapToInt(lottoNumber->Integer.parseInt(lottoNumber.trim()))
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
        LottoController lottoController = new LottoController();
        List<String> lottoNumberInputList = new ArrayList<>();
        lottoNumberInputList.add("1, 2, 3, 4, 5, 6");
        lottoNumberInputList.add("1, 2, 3, 4, 5, 7");
        lottoNumberInputList.add("1, 2, 3, 4, 7, 8");
        lottoNumberInputList.add("1, 2, 3, 7, 8, 9");
        WinInquiryRequest winInquiryRequest  = new WinInquiryRequest("1, 2, 3, 4, 5, 6", lottoNumberInputList);

        // when
        WinInquiryResponse winInquiryResponse = lottoController.inquiryWin(winInquiryRequest);

        // then
        for (WinStatistic winStatistic : winInquiryResponse.getWinStatisticList()) {
            assertThat(1).isEqualTo(winStatistic.getMatchLottoCount());
        }
        assertThat(500388.75).isEqualTo(winInquiryResponse.getTotalReturnRate());
    }
}