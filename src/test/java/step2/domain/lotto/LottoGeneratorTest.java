package step2.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoGeneratorTest {

    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 45;
    private static final Integer SIZE = 6;

    @DisplayName("로또 번호 생성 조건을 모두 만족해야 함")
    @Test
    void createLottoWithAllConditions() {
        // given
        LottoGenerator lottoGenerator = new LottoGenerator(MIN_NUMBER, MAX_NUMBER, SIZE);

        // when
        List<Integer> generated = lottoGenerator.generateLotto();

        // then
        Assertions.assertThat(generated)
                .hasSize(SIZE)
                .doesNotHaveDuplicates()
                .allSatisfy(number -> Assertions.assertThat(number).isBetween(MIN_NUMBER, MAX_NUMBER));
    }
}
