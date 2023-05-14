package autolotto.lotto;

import autolotto.lotto.fixture.FixedNumberShuffler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

class LottoGeneratorTest {

    private final Predicate<Integer> isNumberOfLottoRange = number -> number >= 1 && number <= 45;
    private final LottoGenerator lottoGenerator = new LottoGenerator(new FixedNumberShuffler());

    @Test
    void 로또생성기는_1에서_45_사이의_수로_이루어진_6개의_번호를_생성한다() {
        List<Integer> numbers = lottoGenerator.generateLottoRangeNumbers();

        int createdNumbersSize = numbers.size();

        Assertions.assertThat(createdNumbersSize).isEqualTo(6);
        Assertions.assertThat(numbers)
                .filteredOn(isNumberOfLottoRange)
                .hasSize(createdNumbersSize);
    }

    @Test
    void 로또생성기는_중복되지_않은_수_6개를_생성한다() {
        List<Integer> numbers = lottoGenerator.generateLottoRangeNumbers();

        Assertions.assertThat(numbers).doesNotHaveDuplicates();
    }

    @Test
    void 금액_3000_원이_주어지면_3개의_로또를_생성한다() {
        int money = 3000;

        List<Lotto> lottos = lottoGenerator.generateLottos(money);

        Assertions.assertThat(lottos).hasSize(3);
    }
}
