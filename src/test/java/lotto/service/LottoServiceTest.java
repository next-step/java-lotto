package lotto.service;

import lotto.service.domain.LottoResultMaker;
import lotto.service.domain.LottoTicket;
import lotto.service.domain.LottoTicketRandomMaker;
import lotto.service.domain.WinningLottoTicket;
import lotto.service.dto.LottoPurchaseDTO;
import lotto.service.dto.LottoResultCreateDTO;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;
import lotto.service.value.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setup() {
        lottoService = new LottoService(new LottoResultMaker());
    }

    @Test
    @DisplayName("로또복권들 정상 구입 검증")
    void purchaseLottoTickets() {
        Integer purchaseQuantity = 5;
        LottoPurchaseDTO lottoPurchaseDTO = LottoPurchaseDTO.from(purchaseQuantity);
        LottoTickets lottoTickets = lottoService.purchaseLottoTickets(lottoPurchaseDTO);
        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets.getCountOfLottoTickets()).isEqualTo(purchaseQuantity);
    }

    @Test
    @DisplayName("파라미터 값이 없는 경우 예외 발생 검증")
    void purchaseLottoTickets_exception() {
        assertThatNullPointerException().isThrownBy(() -> lottoService.purchaseLottoTickets(null));
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
    @DisplayName("로또당첨 결과 정상 생성여부 검증")
    void checkLottoResult() {
        LottoResult lottoResult = lottoService.checkLottoResult(getTestLottoCreateResultDTO());
        assertThat(lottoResult).isNotNull();
    }

    @Test
    @DisplayName("파라미터 값이 없는 경우 예외 발생 검증")
    void checkLottoResult_exception() {
        assertThatNullPointerException().isThrownBy(() -> lottoService.checkLottoResult(null));
    }

    private LottoResultCreateDTO getTestLottoCreateResultDTO() {
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(getTestLottoNumber(), 7);
        LottoTicket lottoTicket = LottoTicket.from(getTestLottoNumber());

        LottoTickets lottoTickets = LottoTickets.from(Collections.singletonList(lottoTicket));
        return LottoResultCreateDTO.of(lottoTickets, winningLottoTicket);
    }

    private List<LottoNumber> getTestLottoNumber() {
        return Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                             LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6));
    }
}
