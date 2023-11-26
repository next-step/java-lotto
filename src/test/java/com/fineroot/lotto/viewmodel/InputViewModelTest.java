package com.fineroot.lotto.viewmodel;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.lotto.domain.LottoBundle;
import com.fineroot.lotto.domain.LottoNumber;
import com.fineroot.lotto.domain.LottoPayment;
import com.fineroot.lotto.domain.vo.LotteryCount;
import com.fineroot.lotto.dto.WinningNumber;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewModelTest {

    @ParameterizedTest
    @DisplayName("당첨 번호 저장 및 확인")
    @CsvSource({"'1, 2, 3, 4, 5, 7',1,true", "'1, 2, 3, 4, 5, 6',7,false"})
    void saveWinningNumberAndBonusNumber(String dummy, int input, boolean expected) {
        String winNumber = "1, 2, 3, 4, 5, 6";
        InputViewModel inputViewModel = new InputViewModel();
        inputViewModel.saveWinningNumber(WinningNumber.from(winNumber));
        inputViewModel.saveBonusNumber(LottoNumber.from(7));
        assertThat(inputViewModel.getWinningNumberSet().contains(LottoNumber.from(input))).isEqualTo(expected);
        assertThat(inputViewModel.getWinningNumberSet().hasBonus(
                Arrays.stream(dummy.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .map(LottoNumber::from)
                        .collect(Collectors.toList()))).isEqualTo(expected);
    }

    @Test
    @DisplayName("수동 로또 장 수 저장")
    void saveManualPurchaseCount() {
        InputViewModel inputViewModel = new InputViewModel();
        inputViewModel.saveLottoPayment(LottoPayment.from(10000));
        inputViewModel.saveManualPurchaseCount(LotteryCount.from(5));
        assertThat(inputViewModel.getLotteryOrderSet().getManualLotteryCount()).isEqualTo(LotteryCount.from(5));
    }

    @Test
    @DisplayName("각 수동 로또 저장")
    void saveManualLottoBundle() {
        LottoBundle dummy = LottoBundle.fromList(List.of("1,2,3,4,5,6", "7,8,9,10,11,12", "13,14,15,16,17,18"));
        InputViewModel inputViewModel = new InputViewModel();
        inputViewModel.saveLottoPayment(LottoPayment.from(10000));
        inputViewModel.saveManualPurchaseCount(LotteryCount.from(3));
        inputViewModel.saveManualLottoBundle(dummy);
        assertThat(inputViewModel.getLotteryOrder().lottoBundle().size()).isEqualTo(10);
    }

    @ParameterizedTest
    @DisplayName("인덱스 검증 확인")
    @CsvSource({"2,false","3,false","4,true"})
    void manualLotteryIsGreaterThan(int input, boolean expected) {
        InputViewModel inputViewModel = new InputViewModel();
        inputViewModel.saveLottoPayment(LottoPayment.from(10000));
        inputViewModel.saveManualPurchaseCount(LotteryCount.from(3));

        assertThat(inputViewModel.manualLotteryIsGreaterThan(input)).isEqualTo(expected);
    }
}
