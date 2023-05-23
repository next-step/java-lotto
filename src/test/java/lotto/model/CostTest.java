package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CostTest {

    @DisplayName("구입 비용 테스트(0이상 입력)")
    @ParameterizedTest
    @ValueSource(ints = {0, 1000, 3000})
    void 로또_구입비용_0원이상(int input) {
        assertTrue(new Cost(new Money(input)).getMoney() >= 0);
    }

    @DisplayName("구입 비용 테스트(음수값 입력)")
    @ParameterizedTest
    @ValueSource(ints = {-1, -1000, -3000})
    void 로또_구입비용_음수(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cost(new Money(input)))
                .withMessageMatching("금액은 음수일 수 없습니다.");
    }

    @DisplayName("구입 금액에 따른 로또 티켓 개수")
    @ParameterizedTest
    @ValueSource(ints = {1000, 1001})
    void 구입_금액에_따른_로또_티켓_개수(int input) {
        assertThat(new Cost(new Money(input)).getLottoTicketCount()).isEqualTo(1);
    }

    @DisplayName("주어진 금액으로 티켓을 살 수 없는 경우")
    @Test
    void 티켓_구매_비용_부족() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cost(new Money(999)).getLottoTicketCount())
                .withMessageMatching("해당 금액으로 티켓을 살 수 없습니다.");
    }
}
