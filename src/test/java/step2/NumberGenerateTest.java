package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.LottoFactory;
import step2.domain.LottoGenerateStrategy;
import step2.infrastructure.ManualStrategy;
import step2.infrastructure.RandomStrategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGenerateTest {

    List<Integer> numberList;

    @BeforeEach
    void init() {
        numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 구매_번호_리스트는_외부_전략대로_생성된다() {

        // given
        LottoGenerateStrategy strategy = () -> Collections.singletonList(numberList);

        // when
        List<List<Integer>> result = LottoFactory.generateLotto(strategy);

        // then
        assertThat(result).contains(numberList);
    }

    @Test
    void 자동_생성_번호는_amount만큼_생성된다() {

        // given
        LottoGenerateStrategy strategy = new RandomStrategy(5);

        // when
        List<List<Integer>> result = LottoFactory.generateLotto(strategy);

        // then
        assertThat(result).hasSize(5);
    }

    @Test
    void 수동_생성_번호는_문자열이_숫자로_변환돼서_생성된다() {

        // given
        List<String> numbers = Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7");
        List<Integer> firstList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> secondList = Arrays.asList(2, 3, 4, 5, 6, 7);
        LottoGenerateStrategy strategy = new ManualStrategy(numbers);

        // when
        List<List<Integer>> result = LottoFactory.generateLotto(strategy);

        // then
        assertThat(result).hasSize(2);
        assertThat(result).contains(firstList);
        assertThat(result).contains(secondList);
    }
}
