package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoStoreTest {

    private LottoStore store;

    @BeforeEach
    public void setUp() {
        store = new LottoStore();
    }

    @Test
    void 로또개수를_구한다() {
        // given
        int money = 14000;
        int expected = 14;

        LottoStore store = new LottoStore() {
            @Override
            protected int calculateLottoCount(int money) {
                return super.calculateLottoCount(money);
            }
        };

        // when
        int actual = store.calculateLottoCount(money);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 구매금액이_부족하면_예외가_발생한다() {
        // given
        int money = 900;

        LottoStore store = new LottoStore() {

            @Override
            protected void checkMoney(int money) {
                super.checkMoney(money);
            }
        };

        // sad case
        assertThatThrownBy(() -> store.checkMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
