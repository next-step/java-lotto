package com.jaeyeonling.lotto.utils;

import com.jaeyeonling.lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringToLottoTransferTest {

    @DisplayName("문자열로 된 로또 숫자들을 Lotto로 변환 ")
    @Test
    void should_return_lotto_when_transform() {
        // when
        final Lotto lotto = StringToLottoTransfer.transform("1,2,3,4,5,6");

        // thenK
        assertThat(lotto).isNotNull();
    }
}
