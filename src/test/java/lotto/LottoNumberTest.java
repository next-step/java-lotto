package lotto;

import common.StringResources;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @Test
    public void makeLottoNumberSuccess() {

        List<Integer> fullNumberList = Stream.iterate(1, i -> i + 1)
                .limit(45)
                .collect(Collectors.toList());

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Collections.shuffle(fullNumberList, random);

            List<Integer> numbers = fullNumberList.subList(0, 6);
            Collections.sort(numbers);
            assertThat(new LottoNumber(numbers)).isNotNull();
        }
    }

    @Test
    public void wrongRangeNumbers() {

        List<Integer> hasTooSmallValueList = Arrays.asList(0, 1, 2, 3, 4, 5);
        List<Integer> hasTooLargeValueList = Arrays.asList(46, 1, 2, 3, 4, 5);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(hasTooSmallValueList))
                .withMessage(StringResources.ERR_WRONG_RANGE_NUMBER);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(hasTooLargeValueList))
                .withMessage(StringResources.ERR_WRONG_RANGE_NUMBER);
    }

    @Test
    public void duplicateNumbers() {

        List<Integer> hasDuplicatedNumberList = Arrays.asList(1, 1, 2, 3, 4, 5);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(hasDuplicatedNumberList))
                .withMessage(StringResources.ERR_DUPLICATE_NUMBER);
    }
}
