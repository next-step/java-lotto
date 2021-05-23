package com.lotto;

import com.lotto.domain.LottoGroup;
import com.lotto.exception.IllegalPriceException;
import com.lotto.exception.LottoPriceOutOfBoundsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGroupTest {
    @Test
    void createLottoGroup_생성() {
        LottoGroup lottoGroup = LottoGroup.createLottoGroup("14000");
        assertThat(lottoGroup.size()).isEqualTo(14);
    }

    @ParameterizedTest
    @ValueSource(strings = {"999"})
    void createLottoGroup_생성실패_단위가격이하(String price) {
        assertThatThrownBy(() -> LottoGroup.createLottoGroup(price))
                .isInstanceOf(LottoPriceOutOfBoundsException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1, 0, text"})
    void createLottoGroup_생성실패_잘못된가격(String price) {
        assertThatThrownBy(() -> LottoGroup.createLottoGroup(price))
                .isInstanceOf(IllegalPriceException.class);
    }
}
