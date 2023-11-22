package com.fineroot.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.lotto.dto.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    @DisplayName("Lotto 생성")
    void create() {
        Lotto lotto = Lotto.create();
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("Lotto Number 확인")
    void isContain() {
        Lotto lotto = Lotto.from(1, 2, 3, 4, 5, 6);
        assertThat(lotto.matchWithWinningNumber(WinningNumber.from("1, 2, 3, 4, 5, 6")).getMatchCount()).isEqualTo(6);
        assertThat(lotto.matchWithWinningNumber(WinningNumber.from("1, 2, 3, 4, 5, 8")).getMatchCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("toString 테스트")
    void string() {
        assertThat(Lotto.from(1, 2, 3, 4, 5, 6).toString()).hasToString("1, 2, 3, 4, 5, 6");
    }
}
