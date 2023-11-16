package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.dto.LottoRequest;
import step2.exception.InvalidExceedPriceException;
import step2.exception.InvalidPriceUnitException;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoRequestTest {

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 에러 발생한다")
    public void invalid_price_unit() {
        assertThatExceptionOfType(InvalidPriceUnitException.class)
            .isThrownBy(() -> {
                new LottoRequest("1200", Collections.emptyList());
            }).withMessageMatching("구매 금액은 1000원 단위여야합니다");
    }

    @Test
    @DisplayName("구입 금액보다 수동 구매 번호가 많을 경우 에러 발생한다")
    public void exceed_manual_numbers() {
        assertThatExceptionOfType(InvalidExceedPriceException.class)
            .isThrownBy(() -> {
                new LottoRequest("1000",
                    Arrays.asList("8, 21, 23, 41, 42, 43",
                        "3, 5, 11, 16, 32, 38"));
            }).withMessageMatching("구매 금액보다 번호가 많습니다");
    }

}
