package lotto.domain;

import lotto.strategy.LottoGenerator;
import lotto.strategy.LottoRandomGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    LottoGenerator lottoRandomGenerator = new LottoRandomGenerator();

    @Test
    void 자동생성테스트_로또는_6자리_숫자이다() {
        Lotto lotto = lottoRandomGenerator.generate();
        assertThat(lotto.numbers().size()).isEqualTo(6);
    }

    @Test
    void 자동생성테스트_로또숫자는_중복되지_않는다() {
        Lotto lotto = lottoRandomGenerator.generate();
        Set<LottoNumber> deduplication = Set.copyOf(lotto.numbers());
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
    void 로또_일치_확인(List<Integer> lottoList, LottoResult expected) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), new LottoNumber(7));
        Lotto lotto = new Lotto(lottoList);

        LottoResult lottoResult = winningLotto.getLottoResult(lotto);

        assertThat(lottoResult).isEqualTo(expected);
    }

    private static List<Arguments> LottoMatchParameterProvider() {
        return List.of(
                Arguments.of(Arrays.asList(1, 3, 5, 7, 9, 11), LottoResult.THREE),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 9, 11), LottoResult.FOUR),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 11), LottoResult.FIVE),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), LottoResult.BONUS),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), LottoResult.SIX),
                Arguments.of(Arrays.asList(6, 7, 8, 9, 10, 11), LottoResult.FAIL)
        );
    }

    @Test
    void 로또_오름차순정렬() {
        Lotto lotto = new Lotto(6, 4, 2, 1, 3, 5);
        assertThat(lotto.numbers()).containsExactly(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
    }

}
