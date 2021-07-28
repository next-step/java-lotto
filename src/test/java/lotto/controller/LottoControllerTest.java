package lotto.controller;

import lotto.domain.LottoList;
import lotto.domain.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {
    private static final int LOTTO_PRICE = 1000;

    @ValueSource(ints = {
            100, 1000, 10000
    })
    @ParameterizedTest
    void buyLotto(int intMoney) {
        LottoList lottoList = LottoController.getInstance().buyLotto(intMoney);
        assertThat(lottoList.size())
                .isEqualTo(intMoney / LOTTO_PRICE);
    }

    @Test
    void checkLottoList() {
    }
}