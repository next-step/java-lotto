package lotto;

import lotto.domain.LottoGame;
import lotto.domain.object.Lotto;
import lotto.vo.LottoList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {

    @ParameterizedTest
    @MethodSource(value = {"getEmptyCase", "getInvalidCase"})
    void testInvalidCase(final String money) {
        assertThatThrownBy(() -> { new LottoGame(money); })
                .isInstanceOf(RuntimeException.class);
    }

    static Stream<String> getEmptyCase() {
        return Stream.of(null, "", " ");
    }
    static Stream<String> getInvalidCase() {
        return Stream.of("-1", "&");
    }

    @ParameterizedTest
    @CsvSource(value = {"3000=3", "2300=2", "24102=24", "2403=2"}, delimiter = '=')
    void testCreationLotto(final int money, final int count) {
        final int PER_SALE_PRICE = 1000;
        assertThat(new LottoList(money/PER_SALE_PRICE).getCount()).isEqualTo(count);
    }

    @Test
    void testValidationLotto() {
        final Lotto lotto = new Lotto(new int[]{1,2,3,4,5});
        assertThat(lotto).isEqualTo(new int[]{1,2,3,4,5});
    }

    @Test
    void testAscendingSort() {
        final Lotto lotto = new Lotto(new int[]{4,2,41,1,23});
        assertThat(lotto).isEqualTo(new int[]{1,2,4,23,41});
    }

    @Test
    void testJudgementLotto() {
        final int[] LUCKY_NUMBERS = new int[]{1,2,3,4,5};
        final Lotto lotto = new Lotto(new int[]{4,2,41,1,23});
        assertThat(lotto.countMatch(LUCKY_NUMBERS)).isEqualTo(3);
    }

    @Test
    void testCalculationPrize() {
        final int[] LUCKY_NUMBERS = new int[]{1,2,3,4,5};
        final LottoList list = new LottoList(new int[][]{ {3,4,5,6,7}, {31,24,35,23,45} });
        assertThat(list.getTotalPrize(LUCKY_NUMBERS)).isEqualTo(5000);
    }

    @Test
    void testCalculationEarningsRate() {
        final int PER_SALE_PRICE = 1000;
        final int TOTAL_PURCHASE = 10 * PER_SALE_PRICE;
        final int[] LUCKY_NUMBERS = new int[]{1,2,3,4,5};
        final LottoList list = new LottoList(new int[][]{ {3,4,5,6,7}, {31,24,35,23,45} });
        final int totalPrize = list.getTotalPrize(LUCKY_NUMBERS);
        assertThat(list.getEarningsRate(totalPrize, TOTAL_PURCHASE)).isEqualTo(0.5f);
    }
}
