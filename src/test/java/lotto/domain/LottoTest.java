package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    @DisplayName("[요구사항 2] 당첨 번호와 동일한 번호들을 가진 로또를 구입했을 때 일치되는 숫자는 6개이다.")
    void 요구사항_2() {
        // given: 당첨 복권
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int expectedMatchCount = 6;

        // when: 복권 당첨 번호와 같은 번호들을 가진 로또 구입
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // then
        assertThat(lotto.getMatchNumbers(winningNumbers)).isEqualTo(expectedMatchCount);
    }
}
