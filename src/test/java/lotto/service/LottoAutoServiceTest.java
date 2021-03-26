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
    @ValueSource(ints = {999, 500, 0, -1})
    @DisplayName("로또 구매금액은 최소 1000원 이상이어야 한다.")
    void purchaseAmount(int purchaseAmount) {
        // given
        LottoAutoService lottoAutoService = new LottoAutoService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoAutoService.purchaseLottoTicket(purchaseAmount))
                .withMessageMatching("최소 1000원 이상의 금액을 입력해 주세요.");
    }

    @Test
    @DisplayName("로또 구매결과 구매금액을 1000원 단위로 나눈 수만큼의 티켓이 존재해야 한다.")
    void purchaseCount() {
        // given
        int purchaseAmount = 14000;
        int lottoPrice = 1000;
        LottoAutoService lottoAutoService = new LottoAutoService();

        // when
        LottoTicket lottoTicket = lottoAutoService.purchaseLottoTicket(purchaseAmount);

        // then
        assertThat(purchaseAmount / lottoPrice).isEqualTo(lottoTicket.getCount());
    }

    @Test
    @DisplayName("inquiryWin 기본테스트")
    void inquiryWin() {
        // given
        List<String> lottoNumberInputList = new ArrayList<>();
        lottoNumberInputList.add("1, 2, 3, 4, 5, 6");
        LottoAutoService lottoAutoService = new LottoAutoService();

        // when
        LottoRanks lottoRanks = lottoAutoService.inquiryWin(lottoNumberInputList, new int[]{1, 2, 3, 4, 5, 6});

        // then
        assertThat(1).isEqualTo(lottoRanks.matchLottoCount(LottoRank.ONE));
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
        LottoRanks lottoRanks = lottoAutoService.inquiryWin(lottoNumberInputList, new int[]{1, 2, 3, 4, 5, 6});

        // then
        assertThat(667183.33).isEqualTo(lottoRanks.totalReturnRate());
    }

}