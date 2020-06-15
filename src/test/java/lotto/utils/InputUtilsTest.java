package lotto.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class InputUtilsTest {

    private InputUtils inputUtils;

    @BeforeEach
    void setUp() {
        inputUtils = new InputUtils();
    }

    @DisplayName("0보다 작은 숫자 입력시 에러 발생")
    @Test
    void validMoneyGreaterZero() {
        assertThatIllegalArgumentException().isThrownBy(()->  inputUtils.validMoneyGreaterZero(-100));
    }

    @DisplayName("천원으로 1게임 구매가능 값 반환")
    @Test
    void parserMoney() {
        int count = inputUtils.parserMoney(1000);
        assertThat(count).isEqualTo(1);
    }

    @DisplayName("딱 맞는 금액이 아닌 돈으로 3게임 구매")
    @Test
    void parserMoneyWithSpecialMoeny() {
        int count = inputUtils.parserMoney(3534);
        assertThat(count).isEqualTo(3);
    }

    @DisplayName("숫자 입력값에 따른 파싱")
    @Test
    void stringToArray() {
        List result = inputUtils.stringToArray("10, 20, 30, 33, 35");
        assertThat(result.size()).isEqualTo(5);
        assertThat(result).contains(10,20,30,33,35);
    }

    @Test
    void isEmpty() {
    }
}