package lotto;

import lotto.domain.LottoGame;
import lotto.domain.object.Lotto;
import lotto.vo.LottoGrade;
import lotto.vo.LottoList;
import lotto.vo.LottoResult;
import lotto.vo.LottoResultCount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {

    static Stream<String> getEmptyCase() {
        return Stream.of(null, "", " ");
    }

    static Stream<String> getInvalidCase() {
        return Stream.of("-1", "&");
    }

    @ParameterizedTest
    @MethodSource(value = {"getEmptyCase", "getInvalidCase"})
    void testInvalidCase(final String money) {
        assertThatThrownBy(() -> {
            new LottoGame(money);
        })
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"3000=3", "2300=2", "24102=24", "2403=2"}, delimiter = '=')
    void testCreationLotto(final int money, final int count) {
        final int PER_SALE_PRICE = 1000;
        assertThat(new LottoList(money / PER_SALE_PRICE).getCount()).isEqualTo(count);
    }

    @Test
    void testValidationLotto() {
        final Lotto lotto = new Lotto(new int[]{1, 2, 3, 4, 5});
        assertThat(lotto).isEqualTo(new int[]{1, 2, 3, 4, 5});
    }

    @Test
    void testAscendingSort() {
        final Lotto lotto = new Lotto(new int[]{4, 2, 41, 1, 23});
        assertThat(lotto).isEqualTo(new int[]{1, 2, 4, 23, 41});
    }

    @Test
    void testJudgementLotto() {
        final Lotto lotto = new Lotto(new int[]{4, 2, 41, 1, 23});
        final Lotto LUCKY_NUMBERS = new Lotto(new int[]{1, 2, 3, 4, 5});
        assertThat(lotto.countMatch(LUCKY_NUMBERS)).isEqualTo(3);
    }

    @Test
    void testJudgementLottoWithGrade() {
        final LottoList list = new LottoList(new int[][]{{3, 4, 5, 6, 7}, {4, 24, 35, 23, 45}});

        final Lotto LUCKY_NUMBERS = new Lotto(new int[]{1, 2, 3, 4, 5});
        final LottoGrade GRADE_3 = LottoGrade.fromMatchCount(3);

        assertThat(list.getResultWithGrade(LUCKY_NUMBERS, GRADE_3)).isEqualTo(new LottoResultCount(1));
    }

    @Test
    void testCalculationPrize() {
        final LottoList list = new LottoList(new int[][]{{3, 4, 5, 6, 7}, {31, 24, 35, 23, 45}});

        final Lotto LUCKY_NUMBERS = new Lotto(new int[]{1, 2, 3, 4, 5});
        final LottoResult result = list.getResult(LUCKY_NUMBERS);

        assertThat(result.getPrize()).isEqualTo(5000);
    }

    @Test
    void testCalculationEarningsRate() {
        final int[][] lottos = new int[][]{{3, 4, 5, 6, 7}, {31, 24, 35, 23, 45}};
        final LottoGame game = new LottoGame(lottos);

        final Lotto LUCKY_NUMBERS = new Lotto(new int[]{1, 2, 3, 4, 5});
        final LottoResult result = game.getResult(LUCKY_NUMBERS);
        final int totalPrize = result.getPrize();

        assertThat(game.getEarningsRate(totalPrize)).isEqualTo(2.5f);
    }
}
