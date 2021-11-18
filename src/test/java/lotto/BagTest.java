package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * [기능분석]
 * 가방은 돈을 저장 할 수 있다. (돈을 입력 받는다)
 * 가방은 최대한 많이 로또를 구매할 수 있다. (로또 한장당 가격을 입력 받는다)
 * 가방은 로또를 살 돈이 충분하지 않으면 로또 구매가 불가능하다
 * 가방은 로또의 당첨 결과를 알 수 있다. (당첨번호를 입력 받는다)
 * 가방은 총 수익을 계산할 수 있다. (각 등수의 금액과 당첨번호를 입력 받는다)
 */
public class BagTest {
    private static final int LOTTO_UNIT_PRICE = 1000;

    @ParameterizedTest
    @ValueSource(ints = {10000, 15000, 18000})
    @DisplayName("가방은 Client 로부터 금액을 입력받아 저장 할 수 있다.")
    void 돈_저장(int input) {
        Bag bag = new Bag(input);
        assertThat(bag).isEqualTo(new Bag(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {12000, 15000, 18000})
    @DisplayName("가방은 최대한 많이 로또를 구매할 수 있다.")
    void 로또구매(int input) {
        Bag bag = new Bag(input);
        bag.buyLotto(new Money(LOTTO_UNIT_PRICE));

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < input / LOTTO_UNIT_PRICE; i++) {
            lottos.add(new Lotto());
        }

        Bag other = new Bag(0, lottos);
        assertThat(bag).isEqualTo(other);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 500, 900})
    @DisplayName("가방은 로또를 살 돈이 충분하지 않으면 로또 구매가 불가능하다")
    void 로또구매_실패(int input) {
        assertThatThrownBy(() -> {
            Bag bag = new Bag(input);
            bag.buyLotto(new Money(LOTTO_UNIT_PRICE));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
