package com.fineroot.lotto.viewmodel;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.lotto.dto.LottoBundleStatus;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultViewModelTest {

    @Test
    @DisplayName("LottoCount 저장 및 확인")
    void saveLottoCount() {
        ResultViewModel resultViewModel = new ResultViewModel();
        resultViewModel.saveLottoCount(10);
        assertThat(resultViewModel.getLottoCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("LotteryBundleStatus 저장 및 확인")
    void saveLotteryBundleStatus() {
        ResultViewModel resultViewModel = new ResultViewModel();
        resultViewModel.saveLotteryBundleStatus(LottoBundleStatus.from(List.of("1,2,3,4,5,6","7,8,9,10,11,12")));
        assertThat(resultViewModel.getLotteryBundleStatus().get(0)).isEqualTo("1,2,3,4,5,6");
        assertThat(resultViewModel.getLotteryBundleStatus().get(1)).isEqualTo("7,8,9,10,11,12");
    }
}