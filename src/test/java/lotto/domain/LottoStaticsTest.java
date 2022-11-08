package lotto.domain;

import lotto.view.Output;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoStaticsTest {

    private static List<Lotto> lottoList;
    private static List<Integer> winnerNumberList = List.of(1, 2, 3, 4, 5, 6);

    @Test
    void test_Throw_IllegalArgumentException_If_lottoList_has_null() {
        lottoList = null;

        assertThatThrownBy(() -> LottoStatics.calculate(lottoList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_given_value_If_givenNumbers_make_lottoList() {
        lottoList = Arrays.asList(
                new Lotto(givenNumbers(1, 2, 3, 4, 5, 6)),
                new Lotto(givenNumbers(1, 2, 3, 4, 5, 7)),
                new Lotto(givenNumbers(1, 2, 3, 4, 7, 8)),
                new Lotto(givenNumbers(1, 2, 3, 7, 8, 9)),
                new Lotto(givenNumbers(1, 2, 7, 8, 9, 10)),
                new Lotto(givenNumbers(1, 7, 8, 9, 10, 11)),
                new Lotto(givenNumbers(7, 8, 9, 10, 11, 12))
        );

        List<Lotto> matchLottoList = Output.getRank(lottoList, winnerNumberList, 12);
        assertThat(LottoStatics.calculate(lottoList)).isEqualTo(BigDecimal.valueOf(2900.08));
    }

    private static List<LottoNumber> givenNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
