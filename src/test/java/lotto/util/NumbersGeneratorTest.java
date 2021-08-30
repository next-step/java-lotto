package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersGeneratorTest {


    @Test
    @DisplayName("입력한 당첨번호를 List로 생성할 수 있다.")
    void lottoWinSaveTest() {

        // given
        String[] input = "1, 2, 3, 4, 5, 6".split(", ");
        List<Number> expected = Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(Number::new)
            .collect(Collectors.toList());

        // when
        List<Number> inputs = NumbersGenerator.generateNumbers(input);

        // then
        assertThat(inputs).isEqualTo(expected);
    }

}
