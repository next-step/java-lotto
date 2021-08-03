package edu.nextstep.lotto.step2.domain;

import edu.nextstep.lotto.common.BusinessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningListTest {

    @DisplayName("당첨 번호 생성 테스트")
    @Test
    void create() {
        WinningList winningList = new WinningList("1,2,3,4,5,6");
        assertThat(winningList.getWinningNumberList().size()).isEqualTo(6);
    }

    @DisplayName("당첨 번호 생성 테스트 (6개가 아닐 경우)")
    @Test
    void create_exception_invalid_count() {
        assertThatThrownBy(() -> new WinningList("1,2,3,4,5")).isInstanceOf(BusinessException.class);
    }

    @DisplayName("당첨 번호 생성 테스트 (숫자가 아닐 경우)")
    @Test
    void create_exception_not_number() {
        assertThatThrownBy(() -> new WinningList("1,2,3,4,5,aa")).isInstanceOf(BusinessException.class);
    }
}