package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("구매금액 3,000 원의 구매가능수량은 3이다")
    void getQuantity() {
        assertThat(new Lotto("3000").getBuyQuantity()).isEqualTo(3);
    }

    @Test
    @DisplayName("구매금액 5000 원으로 자동을 돌린 후의 로또수량은 5이다")
    void auto() {
        Lotto lotto = new Lotto("5000");
        lotto.auto();
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 1000원으로 자동을 여러 번 호출해도 로또수량은 1개이다")
    void lottoMultipleTimesCallAuto() {
        Lotto lotto = new Lotto("1000");
        lotto.auto();
        lotto.auto();
        lotto.auto();
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또구매가능수량을 초과하면 예외가 발생한다")
    void maxQuantityException() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.add(LottoGenerator.generate());
        lottoNumbers.add(LottoGenerator.generate());
        assertThatThrownBy(() -> new Lotto("1000", lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("생성할 수 있는 수량을 초과하였습니다.");
    }

    @Test
    @DisplayName("구매금액이 1,000 단위가 아닐경우 예외가 발생한다")
    void buyPriceException() {
        assertThatThrownBy(() -> new Lotto("1001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1,000원 단위로만 구매 가능합니다.");
    }
}
