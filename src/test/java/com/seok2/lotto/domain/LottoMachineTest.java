package com.seok2.lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import com.seok2.lotto.exception.LottoDuplicateNumberException;
import com.seok2.lotto.exception.PurchaseAmountException;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void throwPurchaseAmountException() {
        assertThatThrownBy(() -> LottoMachine.buy(Money.ZERO, LottoSheet.of(Arrays.asList("1,2,3,4,5,6"))))
        .isInstanceOf(PurchaseAmountException.class);
    }
}