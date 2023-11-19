package lotto.domain;

import lotto.strategy.LottoGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    LottoGenerator lottoRandomGenerator = new LottoRandomGenerator();

    @Test
    void 자동생성테스트_로또는_6자리_숫자이다() {
        Lotto lotto = new Lotto(lottoRandomGenerator);
        assertThat(lotto.numbers().size()).isEqualTo(6);
    }

    @Test
    void 자동생성테스트_로또숫자는_중복되지_않는다() {
        Lotto lotto = new Lotto(lottoRandomGenerator);
        Set<Integer> deduplication = Set.copyOf(lotto.numbers());
        assertThat(deduplication.size()).isEqualTo(6);
    }

    @Test
    void 수동생성테스트_로또숫자_중복일_경우_IllegalArgumentException_오류발생() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 수동생성테스트_로또숫자범위_벗어날_경우_IllegalArgumentException_오류발생(int invalidNumber) {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, invalidNumber));
        }).isInstanceOf(IllegalArgumentException.class);
    }

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
