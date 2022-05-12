package lotto;

import lotto.dto.LottoCount;
import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 구매 개수 정보를 담고있는 클래스")
public class LottoCountTest {

    @Test
    @DisplayName("구매 금액이 null이면 NullPointerException이 발생한다.")
    void CountInfoNullTest() {
        assertThatThrownBy(() -> new LottoCount(null, 3))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("수동 구매 개수가 음수이면 예외가 발생한다.")
    void CountInfoNegativeTest() {
        assertThatThrownBy(() -> new LottoCount(new Money(1000), -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("지불한 금액이 1개당 가격의 배수가 아니면 예외가 발생한다.")
    void moneyUnitTest() {
        assertThatThrownBy(() -> new LottoCount(new Money(12345), 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 금액과 수동 개수를 가지고 수동, 자동 생성 로또 개수를 저장하는 객체를 생성한다.")
    void LottoCountTest() {
        LottoCount lottoCount = new LottoCount(new Money(14000), 3);

        assertThat(lottoCount.getRandomCount()).isEqualTo(11);
        assertThat(lottoCount.getManualCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("수동 구매 개수가 총 구매 가능한 개수보다 많으면 예외가 발생한다.")
    void manualCountTest() {
        assertThatThrownBy(() -> new LottoCount(new Money(14000), 15))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
