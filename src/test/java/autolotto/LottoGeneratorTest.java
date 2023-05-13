package autolotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class LottoGeneratorTest {

    private final Predicate<Integer> isNumberOfLottoRange = number -> number >= 1 && number <= 45;
    private final LottoGenerator lottoGenerator = new LottoGenerator(new OriginalOrderShuffler());

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

    private static class OriginalOrderShuffler implements Shuffler {

        @Override
        public List<Integer> shuffle(List<Integer> originals) {
            return new ArrayList<>(originals);
        }
    }
}
