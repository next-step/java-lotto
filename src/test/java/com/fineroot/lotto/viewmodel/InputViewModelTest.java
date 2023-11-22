package com.fineroot.lotto.viewmodel;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.lotto.dto.Money;
import com.fineroot.lotto.dto.WinningNumber;
import com.fineroot.lotto.domain.LottoNumber;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewModelTest {
    @Test
    @DisplayName("입력 금액 저장 및 확인")
    void saveMoney() {
        InputViewModel inputViewModel = new InputViewModel();
        inputViewModel.saveMoney(Money.from(1000));
        assertThat(inputViewModel.getMoney().getValue()).isEqualTo(1000);
    }

    @Test
    @DisplayName("당첨 번호 저장 및 확인")
    void saveWinningNumber() {
        InputViewModel inputViewModel = new InputViewModel();
        inputViewModel.saveWinningNumber(WinningNumber.from("1, 2, 3, 4, 5, 6"));
        assertThat(inputViewModel.getWinningNumber().getLottoNumbers()).containsAll(
                Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::from).collect(Collectors.toList()));
    }
}
