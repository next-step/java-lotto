package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {

    @ParameterizedTest
    @MethodSource("randomNumberMatchingCase")
    void match_number_find(List<Integer> lottoNum, List<Integer> winningNum, int matchingNum) {
        Lotto lotto = new Lotto(lottoNum);
        assertThat(lotto.findMatchingNum(winningNum)).isEqualTo(matchingNum);
    }

    static Stream<Arguments> randomNumberMatchingCase() {
        return Stream.of(
                arguments(Lists.list(5, 6, 2, 1, 7, 12), Lists.list(5, 15, 23, 45, 4, 2), 2),
                arguments(Lists.list(12, 19, 23, 1, 7, 12), Lists.list(5, 15, 23, 45, 4, 2), 1)
        );
    }
}
