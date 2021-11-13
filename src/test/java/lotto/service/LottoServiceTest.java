package lotto.service;

import lotto.controller.dto.LottoPurchaseParam;
import lotto.controller.dto.LottoResultParam;
import lotto.service.domain.LottoResultMaker;
import lotto.service.domain.LottoTicket;
import lotto.service.domain.WinningLottoTicket;
import lotto.service.domain.factory.LottoTicketFactory;
import lotto.service.model.LottoNumbers;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;
import lotto.service.value.LottoNumber;
import lotto.service.value.LottoPrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setup() {
        lottoService = new LottoService(new LottoResultMaker(), new LottoTicketFactory());
    }

    @Test
    @DisplayName("로또복권들 정상 구입 검증")
    void purchaseLottoTickets() {
        LottoPrice lottoPrice = LottoPrice.from(5000);
        List<LottoNumbers> lottoNumbers
                = Arrays.asList(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                LottoNumbers.from(Arrays.asList(11, 12, 13, 14, 15, 16)));

        LottoPurchaseParam lottoPurchaseParam = LottoPurchaseParam.of(lottoPrice, lottoNumbers);
        LottoTickets lottoTickets = lottoService.purchaseLottoTickets(lottoPurchaseParam.getAutoLottoQuantity(),
                                                                      lottoPurchaseParam.getLottoNumbersList());
        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets.getCountOfLottoTickets()).isEqualTo(lottoPrice.getLottoQuantity());
    }

    @Test
    @DisplayName("파라미터 값이 없는 경우 예외 발생 검증")
    void purchaseLottoTickets_exception() {
        assertThatNullPointerException().isThrownBy(() -> lottoService.purchaseLottoTickets(null, null));
    }

    @Test
    @DisplayName("당첨복권 정보 정상적으로 가지고오는지 검증")
    void getWinningLottoTicket() {
        WinningLottoTicket winningLottoTicket = lottoService.getWinningLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningLottoTicket).isNotNull();
    }

    @Test
    @DisplayName("당첨번호 값이 없는 경우 예외 발생 검증")
    void getWinningLottoTicket_exception() {
        assertThatNullPointerException().isThrownBy(() -> lottoService.getWinningLottoTicket(null, 7));
    }

    @Test
    @DisplayName("보너스번호 값이 없는 경우 예외 발생 검증")
    void getWinningLottoTicket_exception2() {
        assertThatNullPointerException().isThrownBy(
                () -> lottoService.getWinningLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6), null));
    }

    @Test
    @DisplayName("당첨번호와 보너스번호 같은 경우 예외 발생 검증")
    void getWinningLottoTicket_exception3() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> lottoService.getWinningLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 6));
    }

    @Test
    @DisplayName("로또당첨 결과 정상 생성여부 검증")
    void checkLottoResult() {
        LottoResult lottoResult = lottoService.checkLottoResult(getTestLottoCreateResultDTO().getPurchaseLottoTickets(),
                                                                getTestLottoCreateResultDTO().getWinningLottoTicket());
        assertThat(lottoResult).isNotNull();
    }

    @Test
    @DisplayName("파라미터 값이 없는 경우 예외 발생 검증")
    void checkLottoResult_exception() {
        assertThatNullPointerException().isThrownBy(() -> lottoService.checkLottoResult(null, null));
    }

    private LottoResultParam getTestLottoCreateResultDTO() {
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(getTestLottoNumber(), 7);
        LottoTicket lottoTicket = LottoTicket.from(getTestLottoNumber());

        LottoTickets lottoTickets = LottoTickets.from(Collections.singletonList(lottoTicket));
        return LottoResultParam.of(lottoTickets, winningLottoTicket);
    }

    private List<LottoNumber> getTestLottoNumber() {
        return Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                             LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6));
    }
}
