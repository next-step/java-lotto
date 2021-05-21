package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {

    @Test
    void 입력된_유효하지않은_당첨번호_Test() {
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 3, 4, 5, b"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 3, 4, 5, 6, 7"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 59, 4, 5, 5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 3, -1, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매개수만큼_로또_생성_Test() {
        LottoPurchaseBudget budget = new  LottoPurchaseBudget(5000);
        LottoGenerator generator = new LottoGenerator();
        Lottos lottos = generator.execute(budget.countOfAvailableLotto());

        assertThat(lottos.count()).isEqualTo(5);
    }

    @Test
    void 유효한_로또구매금액_Test() {
        LottoPurchaseBudget budget = new  LottoPurchaseBudget(1000);
        assertThat(budget.equals(new LottoPurchaseBudget(1000)));
    }

    @Test
    void 유효하지않은_로또구매금액_Test() {
        assertThatThrownBy(() -> new LottoPurchaseBudget(999))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoPurchaseBudget(900))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
