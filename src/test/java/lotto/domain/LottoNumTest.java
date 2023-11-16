package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumTest {
    @Test
    @DisplayName("생성/1~45/로또번호생성")
    void lottoNumSuccess() {
        // when then
        assertThat(new LottoNum(1)).isInstanceOf(LottoNum.class);
        assertThat(new LottoNum(45)).isInstanceOf(LottoNum.class);
    }

    @Test
    @DisplayName("생성실패/1~45가아니면/IllegalArgumentException")
    void lottoNumFail() {
        // when then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNum(0));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNum(46));
    }
}