package lotto.service;

import lotto.domain.LottoRank;
import lotto.domain.LottoRanks;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoAutoServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("로또 갯수는 1개 이상이어야 한다.")
    void purchaseLottoTicket(int purchaseCount) {
        // given
        LottoAutoService lottoAutoService = new LottoAutoService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoAutoService.purchaseLottoTicket(purchaseCount))
                .withMessageMatching("최소 1개 이상의 구매수량을 입력해 주세요");
    }

    @Test
    @DisplayName("로또 구매결과 구매장수만큼의 티켓 카운트가 존재해야 한다.")
    void purchaseCount() {
        // given
        int purchaseCount = 14;
        LottoAutoService lottoAutoService = new LottoAutoService();

        // when
        LottoTicket lottoTicket = lottoAutoService.purchaseLottoTicket(purchaseCount);

        // then
        assertThat(purchaseCount).isEqualTo(lottoTicket.getCount());
    }

    @Test
    @DisplayName("로또 구매결과 티켓타입은 자동 티켓이다.")
    void ticketType_Auto() {
        // given
        int purchaseCount = 14;
        LottoAutoService lottoAutoService = new LottoAutoService();

        // when
        LottoTicket lottoTicket = lottoAutoService.purchaseLottoTicket(purchaseCount);

        // then
        assertThat(lottoTicket.isAutoTicket()).isTrue();
    }

    @Test
    @DisplayName("inquiryWin 기본테스트")
    void inquiryWin() {
        // given
        List<String> lottoNumberInputList = new ArrayList<>();
        lottoNumberInputList.add("1, 2, 3, 4, 5, 6");
        LottoAutoService lottoAutoService = new LottoAutoService();

        // when
        LottoRanks lottoRanks = lottoAutoService.inquiryWin(lottoNumberInputList, new int[]{1, 2, 3, 4, 5, 6}, 45);

        // then
        assertThat(1).isEqualTo(lottoRanks.matchLottoCount(LottoRank.FIRST));
    }

    @Test
    @DisplayName("수익률 계산")
    void totalReturnRate() {
        // given
        List<String> lottoNumberInputList = new ArrayList<>();
        lottoNumberInputList.add("1, 2, 3, 4, 5, 6");
        lottoNumberInputList.add("1, 2, 3, 4, 5, 7");
        lottoNumberInputList.add("1, 2, 3, 4, 7, 8");
        LottoAutoService lottoAutoService = new LottoAutoService();

        // when
        LottoRanks lottoRanks = lottoAutoService.inquiryWin(lottoNumberInputList, new int[]{1, 2, 3, 4, 5, 6}, 45);

        // then
        assertThat(667183.33).isEqualTo(lottoRanks.totalReturnRate());
    }

    @Test
    @DisplayName("수익률 계산 - 보너스번호")
    void totalReturnRate_withBonusNumber() {
        // given
        List<String> lottoNumberInputList = new ArrayList<>();
        lottoNumberInputList.add("1, 2, 3, 4, 5, 6");
        lottoNumberInputList.add("1, 2, 3, 4, 5, 7");
        lottoNumberInputList.add("1, 2, 3, 4, 7, 8");
        LottoAutoService lottoAutoService = new LottoAutoService();

        // when
        LottoRanks lottoRanks = lottoAutoService.inquiryWin(lottoNumberInputList, new int[]{1, 2, 3, 4, 5, 6}, 7);

        // then
        assertThat(676683.33).isEqualTo(lottoRanks.totalReturnRate());
    }

}