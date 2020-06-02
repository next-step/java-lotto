package me.daeho.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPurchaseTest {
    @Test
    public void randomCountTest() {
        List<LottoNumber> numbers = new ArrayList<LottoNumber>(){{
            add(LottoNumber.of(1));
            add(LottoNumber.of(2));
            add(LottoNumber.of(3));
            add(LottoNumber.of(4));
            add(LottoNumber.of(5));
            add(LottoNumber.of(6));
        }};

        LottoPurchase lottoPurchase = LottoPurchase.of(
                1000,
                1,
                Collections.singletonList(LottoTicket.issue(numbers))
        );

        LottoPrice lottoPrice = LottoPrice.defaultPrice();

        int randomCount = lottoPurchase.randomCount(lottoPrice);

        assertThat(randomCount).isEqualTo(0);
    }
}