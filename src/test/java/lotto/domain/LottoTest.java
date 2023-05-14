package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("[요구사항 1] 로또 구입 개수 산출 테스트로, 로또를 '정수'개 사야 한다.")
    void 요구사항_1() {
        // given: purchaseAmount(구입 금액) 및 기대 결과 제시
        int purchaseAmount = 13700;
        int expectedResult = 13;

        // then
        assertThat(Lotto.findPurchaseCount(purchaseAmount)).isEqualTo(expectedResult);
    }
}
