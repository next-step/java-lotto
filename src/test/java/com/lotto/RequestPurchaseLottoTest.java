package com.lotto;

import com.lotto.domain.RequestPurchaseLotto;
import com.lotto.exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RequestPurchaseLottoTest {
    private RequestPurchaseLotto requestPurchaseLotto;

    @BeforeEach
    void init() {
        requestPurchaseLotto = new RequestPurchaseLotto();
    }

    @DisplayName("사용자입력: 구매가격이 단위가격 이하일때 예외 발생")
    @Test
    void totalPrice_단위가격이하() {
        assertThatThrownBy(() -> requestPurchaseLotto.setTotalPrice("999"))
                .isInstanceOf(LottoPriceOutOfBoundsException.class);
    }

    @DisplayName("사용자입력: 구매가격의 포맷이 맞지 않을때 예외")
    @Test
    void totalPrice_포맷() {
        assertThatThrownBy(() -> requestPurchaseLotto.setTotalPrice("asd"))
                .isInstanceOf(LottoPriceNumberFormatException.class);
    }

    @DisplayName("사용자입력: 로또번호 수동생성 개수 범위가 맞지않을때 예외")
    @Test
    void manualCount_범위() {
        assertThatThrownBy(() -> requestPurchaseLotto.setManualLottoCount("-1"))
                .isInstanceOf(LottoManualCountOutOfBoundsException.class);
    }

    @DisplayName("사용자입력: 로또번호 수동생성 포맷이 맞지않을때 예외")
    @Test
    void manualCount_포맷() {
        assertThatThrownBy(() -> requestPurchaseLotto.setManualLottoCount("asd"))
                .isInstanceOf(LottoManualCountNumberFormatException.class);
    }
}
