package com.fineroot.lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fineroot.lotto.domain.LottoNumber;
import com.fineroot.lotto.util.ExceptionMessage;
import com.fineroot.lotto.util.LottoNumberCache;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberCacheTest {

    @Test
    @DisplayName("랜덤 숫자 추출")
    void createLottoNumberSet() {
        assertThat(LottoNumberCache.createLottoNumberSet()).hasSize(6);
    }

    @Test
    @DisplayName("cache 내부에 있는 LottoNumber로 변환")
    void fromLottoNumber_shouldBe_sameObject() {
        LottoNumber first = LottoNumberCache.fromLottoNumber(5);
        LottoNumber second = LottoNumberCache.fromLottoNumber(5);
        assertThat(first)
                .isSameAs(second)
                .isNotSameAs(LottoNumber.from(5));
    }

    @Test
    @DisplayName("범위를 넘는 숫자는 예외 출력")
    void fromLottoNumber_shouldBe_throw_exception() {
        assertThatThrownBy(() -> LottoNumberCache.fromLottoNumber(46)).hasMessageContaining(
                ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }
}