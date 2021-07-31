package lotto.domain;

import lotto.exception.OutOfSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @DisplayName("newManual Test")
    @ValueSource(strings = {
            "1,10,20,30,40,45"
    })
    @ParameterizedTest
    public void ctorTest(String strNumbers) {
        assertThatCode(() ->
            Lotto.of(strNumbers)
        ).doesNotThrowAnyException();
    }

    @DisplayName("newManual Test - OutOfSizeException")
    @ValueSource(strings = {
            "1,2,3,4,5",
            "1,2,3,4,5,6,7",
            "1,2,3,4,5,5", // 중복된 번호는 같은 번호로 인식!
            "1,2,3,4,5,5,6" // 번호의 갯수는 6개가 넘으면 안됨
    })
    @ParameterizedTest
    public void ctorTest_OutOfSizeException(String strNumbers) {
        assertThatThrownBy(() ->
                Lotto.of(strNumbers)
        ).isInstanceOf(OutOfSizeException.class);
    }
}
