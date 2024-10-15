package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchTest {

    @Test
    void 로또매치Enum찾기_by맞춘갯수_성공() {
        LottoMatch three = LottoMatch.findEnumByMatchCount(3);
        assertThat(three).isEqualTo(LottoMatch.THREE);
    }

    @Test
    void 로또매치Enum찾기_by맞춘갯수_실패() {
        LottoMatch three = LottoMatch.findEnumByMatchCount(2);
        assertThat(three).isEqualTo(LottoMatch.LOSE);
    }
}
