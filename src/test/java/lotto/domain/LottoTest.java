package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @ParameterizedTest
    @MethodSource("LottoMatchParameterProvider")
    void 로또_일치_확인(List<Integer> lottoList, List<Integer> winningLottoList, LottoResult expected) {
        Lotto lotto = new Lotto(lottoList);
        Lotto winningLotto = new Lotto(winningLottoList);
        LottoResult lottoResult = lotto.match(winningLotto);
        assertThat(lottoResult).isEqualTo(expected);
    }

    private static Stream<Arguments> LottoMatchParameterProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 3, 5, 7, 9, 11), LottoResult.THREE),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 9, 11), LottoResult.FOUR),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 11), LottoResult.FIVE),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), LottoResult.SIX),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(6, 7, 8, 9, 10, 11), LottoResult.FAIL)
        );
    }

}
