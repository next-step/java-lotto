package com.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @DisplayName("로또 생성-가격과 갯수 일치 확인")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "14000,14", "13300,13", "13800,13"})
    void 로또_생성(String price, int expected) {
        LottoManager manager = new LottoManager();
        LottoGroup lottoGroup = manager.issue(price);
        assertThat(lottoGroup.size()).isEqualTo(expected);
    }

    @DisplayName("로또 생성-가격이 음수 또는 문자 예외 확인")
    @ParameterizedTest
    @ValueSource(strings = {"-200", "price"})
    void 로또_가격_음수_또는_문자_예외(String price) {
        LottoManager manager = new LottoManager();
        assertThatThrownBy(() -> manager.issue(price)).isInstanceOf(IllegalArgumentException.class);
    }
}
