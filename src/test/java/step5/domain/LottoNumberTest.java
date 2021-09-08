package step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @DisplayName("에러: 로또 번호 0")
    @Test
    void lottoNumber0() {
        assertThatThrownBy(() -> {
            new LottoNumber(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("에러: 로또 번호 1")
    @Test
    void lottoNumber1() {
        LottoNumber lottoNumber = new LottoNumber(1);
    }

    @DisplayName("에러: 로또 번호 45")
    @Test
    void lottoNumber45() {
        LottoNumber lottoNumber = new LottoNumber(45);
    }

    @DisplayName("에러: 로또 번호 46")
    @Test
    void lottoNumber46() {
        assertThatThrownBy(() -> {
            new LottoNumber(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}