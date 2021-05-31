package step2.util;

import java.util.function.BinaryOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.model.LottoNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoMakeNumbersTest {
    @DisplayName("로또가 1 ~ 45 사이의 숫자로 생성되는지 검증")
    @Test
    void 로또_번호_범위_검증() {
        int expected = 0;
        final BinaryOperator<Integer>
            reducer = (sum, v) -> sum + (v < LottoNumber.MIN || v > LottoNumber.MAX ? 1 : 0);
        for (int i = 0; i < 1000000; i++) {
            assertEquals(expected, LottoMakeNumbers.getRandomNumber()
                .stream()
                .map(LottoNumber::getNumber)
                .reduce(0, reducer));
        }
    }
}
