package step2.view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Number;

class ValidatorTest {

    @DisplayName("최소 구입금액은 1000원 이상")
    @Test
    void validateMinSeed() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateMinSeed(900));
    }

    @DisplayName("최소 0게임 이상부터 가능")
    @Test
    void validateMinManualCount() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateMinManualCount(-1));
    }

    @DisplayName("숫자만 입력가능")
    @Test
    void validateParesInt() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateParesInt("일"));
    }

    @DisplayName("숫자 범위는 1~45")
    @Test
    void validateNumberRange() {
        assertThrows(IllegalArgumentException.class, () -> new Number(46));
    }

    @DisplayName("번호는 6개를 입력해야함")
    @Test
    void validateGameLength() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateGameLength(new String[]{"1","2","3","4","5"}));
    }

    @DisplayName("중복된 번호")
    @Test
    void validateDuplicatedNumber() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateGame("1,2,3,4,5,6,6"));
    }
}