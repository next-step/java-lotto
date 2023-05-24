package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class WinNumTest {
    private static final int LOTTO_NUMS = 6;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final String LOTTO_COUNT_ERORR_MESSAGE = "로또의 개수가 " + LOTTO_NUMS + "개가 아닙니다.";
    private static final String LOTTO_BOUND_ERORR_MESSAGE = MIN_NUM + "에서 " + MAX_NUM + "까지 범위가 아닙니다.";
    private static final String BONUS_BOUND_ERORR_MESSAGE = MIN_NUM + "에서 " + MAX_NUM + "까지 범위가 아닙니다.";

    @Test
    @DisplayName("정상 범위 로또 생성")
    void normalLotto() {
        //give // when
        WinNum winNum = new WinNum(Arrays.asList(1, 8, 23, 41, 42, 45), 7);

        //then
        Assertions.assertThat(winNum.getWinNum().size()).isEqualTo(6);

    }

    @Test
    @DisplayName("최대 범위 로또 생성 오류")
    void maxLotto() {
        Assertions.assertThatThrownBy(() -> {
                    WinNum winNum = new WinNum(Arrays.asList(1, 8, 23, 41, 42, 47), 7);
                }).isInstanceOf(RuntimeException.class)
                .hasMessage(LOTTO_BOUND_ERORR_MESSAGE);

    }

    @Test
    @DisplayName("최대 범위 보너스 생성 오류")
    void maxBonus() {
        Assertions.assertThatThrownBy(() -> {
                    WinNum winNum = new WinNum(Arrays.asList(1, 8, 23, 41, 42, 45), 57);
                }).isInstanceOf(RuntimeException.class)
                .hasMessage(BONUS_BOUND_ERORR_MESSAGE);

    }
}
