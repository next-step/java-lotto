package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * [기능분석]
 * 가방은 돈을 저장 할 수 있다. (돈을 입력 받는다)
 * 가방은 최대한 많이 로또를 구매할 수 있다. (로또 한장당 가격을 입력 받는다)
 * 가방은 로또를 살 돈이 충분하지 않으면 로또 구매가 불가능하다
 * 가방은 로또의 당첨 결과를 알 수 있다. (당첨번호를 입력 받는다)
 * 가방은 총 수익률을 계산할 수 있다. (각 등수의 금액과 당첨번호를 입력 받는다)
 */
public class BagTest {
    private static final int LOTTO_UNIT_PRICE = 1000;
    private static final List<Double> PRIZE_LIST = Arrays.asList(
            0D,
            0D,
            0D,
            5000D,
            5_0000D,
            150_0000D,
            20_0000_0000D
    );

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
    @DisplayName("가방은 로또의 당첨 결과를 알 수 있다. (당첨번호를 입력 받는다)")
    void 로또구매_실패(int input) {
        assertThatThrownBy(() -> {
            Bag bag = new Bag(input);
            bag.buyLotto(new Money(LOTTO_UNIT_PRICE));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("가방은 로또의 당첨 결과를 알 수 있다.")
    void 결과확인() {
        Bag bag = new Bag(0,
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(2, 3, 4, 5, 6, 7),
                new Lotto(3, 4, 5, 6, 7, 8),
                new Lotto(4, 5, 6, 7, 8, 9),
                new Lotto(5, 6, 7, 8, 9, 10),
                new Lotto(6, 7, 8, 9, 10, 11),
                new Lotto(7, 8, 9, 10, 11, 12)
                );

        List<Integer> result = bag.lottoResult(new Lotto(1, 2, 3, 4, 5, 6));

        assertThat(result).isEqualTo(Arrays.asList(1, 1, 1, 1, 1, 1, 1));
    }

    @Test
    @DisplayName("가방은 총 수익률을 계산할 수 있다. (각 등수의 금액과 당첨번호를 입력 받는다)")
    void 수익률계산() {
        Bag bag = new Bag(0,
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(2, 3, 4, 5, 6, 7),
                new Lotto(3, 4, 5, 6, 7, 8),
                new Lotto(4, 5, 6, 7, 8, 9),
                new Lotto(5, 6, 7, 8, 9, 10),
                new Lotto(6, 7, 8, 9, 10, 11),
                new Lotto(7, 8, 9, 10, 11, 12)
        );

        double yield = bag.yield(PRIZE_LIST, new Lotto(1, 2, 3, 4, 5, 6));

        assertThat(yield).isEqualTo(PRIZE_LIST.stream().mapToDouble(e -> e).sum() / PRIZE_LIST.size());
    }
}
