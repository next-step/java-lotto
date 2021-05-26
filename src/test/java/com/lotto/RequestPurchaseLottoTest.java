package com.lotto;

import com.lotto.domain.RequestPurchaseLotto;
import com.lotto.exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RequestPurchaseLottoTest {
    private RequestPurchaseLotto requestPurchaseLotto;

    @BeforeEach
    void init() {
        requestPurchaseLotto = new RequestPurchaseLotto();
    }

    @Test
    void totalPrice_단위가격이하() {
        assertThatThrownBy(() -> requestPurchaseLotto.setTotalPrice("999"))
                .isInstanceOf(LottoPriceOutOfBoundsException.class);
    }

    @Test
    void totalPrice_포맷() {
        assertThatThrownBy(() -> requestPurchaseLotto.setTotalPrice("asd"))
                .isInstanceOf(LottoPriceNumberFormatException.class);
    }

    @Test
    void manualCount_범위() {
        assertThatThrownBy(() -> requestPurchaseLotto.setManualLottoCount("-1"))
                .isInstanceOf(LottoManualCountOutOfBoundsException.class);
    }

    @Test
    void manualCount_포맷() {
        assertThatThrownBy(() -> requestPurchaseLotto.setManualLottoCount("asd"))
                .isInstanceOf(LottoManualCountNumberFormatException.class);
    }
}
