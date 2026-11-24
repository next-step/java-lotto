package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.RepeatedTest;

class RandomLottoGeneratorTest {

    @RepeatedTest(100)
    void 일부터_사십오_사이의_중복_없는_숫자_6개를_생성한다() {
        List<Integer> numbers = new RandomLottoGenerator().generate().getNumbers();

        assertThat(numbers)
                .hasSize(6)
                .doesNotHaveDuplicates()
                .allSatisfy(number -> assertThat(number).isBetween(1, 45));
    }
}
