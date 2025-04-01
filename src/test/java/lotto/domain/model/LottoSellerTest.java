package lotto.domain.model;

import lotto.view.model.LottoInput;
import lotto.view.model.UserMoneyInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoSellerTest {
    private final LottoSeller lottoSeller = new LottoSeller();

    @Test
    @DisplayName("입력한 금액으로 살 수 있는 로또의 장수보다 수동으로 구매한 로또 수가 많으면 예외를 발생시킨다")
    void lottoCountTest() {
        LottoInput lottoInput = LottoInput.from(1000, List.of(List.of(1,2,3,4,5,6), List.of(1,2,3,4,5,6)));
        assertThatThrownBy(() -> lottoSeller.sellManualLotto(lottoInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
