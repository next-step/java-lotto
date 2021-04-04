package lotto.service;

import lotto.domain.LottoRank;
import lotto.domain.LottoRanks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinServiceTest {

    @Test
    @DisplayName("inquiryWin 기본테스트")
    void inquiryWin() {
        // given
        List<String> lottoNumberInputList = new ArrayList<>();
        lottoNumberInputList.add("1, 2, 3, 4, 5, 6");
        LottoWinService lottoWinService = new LottoWinService();

        // when
        LottoRanks lottoRanks = lottoWinService.inquiryWin(lottoNumberInputList, new int[]{1, 2, 3, 4, 5, 6}, 45);

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
        LottoWinService lottoWinService = new LottoWinService();

        // when
        LottoRanks lottoRanks = lottoWinService.inquiryWin(lottoNumberInputList, new int[]{1, 2, 3, 4, 5, 6}, 45);

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
        LottoWinService lottoWinService = new LottoWinService();

        // when
        LottoRanks lottoRanks = lottoWinService.inquiryWin(lottoNumberInputList, new int[]{1, 2, 3, 4, 5, 6}, 7);

        // then
        assertThat(676683.33).isEqualTo(lottoRanks.totalReturnRate());
    }
}