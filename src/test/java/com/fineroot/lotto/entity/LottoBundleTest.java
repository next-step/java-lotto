package com.fineroot.lotto.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBundleTest {
    @Test
    @DisplayName("LottoBundle 생성")
    void create() {
        LottoBundle lottoBundle = LottoBundle.from(10);
        assertThat(lottoBundle).isInstanceOf(LottoBundle.class);
    }

    @Test
    @DisplayName("결과 출력 테스트")
    void lottoBundleStatus() {
        LottoBundle lottoBundle = LottoBundle.from(10);
        assertThat(lottoBundle.toLottoBundleStatus().size()).isEqualTo(10);
    }
}
