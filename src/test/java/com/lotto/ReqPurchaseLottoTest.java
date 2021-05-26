package com.lotto;

import com.lotto.domain.ReqPurchaseLotto;
import com.lotto.exception.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ReqPurchaseLottoTest {
    private ReqPurchaseLotto reqPurchaseLotto;

    @BeforeEach
    void init() {
        reqPurchaseLotto = new ReqPurchaseLotto();
    }

    @Test
    void totalPrice_단위가격이하() {
        assertThatThrownBy(() -> reqPurchaseLotto.setTotalPrice("999"))
                .isInstanceOf(LottoPriceOutOfBoundsException.class);
    }

    @Test
    void totalPrice_포맷() {
        assertThatThrownBy(() -> reqPurchaseLotto.setTotalPrice("asd"))
                .isInstanceOf(LottoPriceNumberFormatException.class);
    }

    @Test
    void manualCount_범위() {
        assertThatThrownBy(() -> reqPurchaseLotto.setManualLottoCount("-1"))
                .isInstanceOf(LottoManualCountOutOfBoundsException.class);
    }

    @Test
    void manualCount_포맷() {
        assertThatThrownBy(() -> reqPurchaseLotto.setManualLottoCount("asd"))
                .isInstanceOf(LottoManualCountNumberFormatException.class);
    }
}
