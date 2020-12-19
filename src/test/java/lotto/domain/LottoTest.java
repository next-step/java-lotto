package lotto.domain;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoTest {
    @Test
    @DisplayName("6개의 1~45 숫자가 정상적으로 저장되는지 테스트")
    void getNumberTest() {
        Lotto lotto = new Lotto(8, 21, 23, 41, 42, 43);
        Lotto otherLotto = new Lotto(8, 21, 23, 41, 42, 43);
        assertThat(lotto.getNumbers()).isEqualTo(otherLotto.getNumbers());
    }

    @Test
    @DisplayName("1~45 숫자가 외의 숫자가 입력시 Exception 발생하는지 테스트")
    void invalidNumberTest() {
        assertThatThrownBy(() -> new Lotto(0, 1, 2, 3, 4, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또와 뽑은 로또간 비교를 한다.")
    @ParameterizedTest
    @MethodSource("generateArgumentsCompareMatchNumberCount")
    void compareMatchNumberCount(List<LottoNumber> lottoLottoNumbers, List<LottoNumber> winnerLottoNumbers, int matchCount) {
        Lotto lotto = new Lotto(Sets.newHashSet(lottoLottoNumbers));
        Lotto winnerLotto = new Lotto(Sets.newHashSet(winnerLottoNumbers));
        assertThat(lotto.matchNumberCount(winnerLotto)).isEqualTo(matchCount);
    }

    private static Stream<Arguments> generateArgumentsCompareMatchNumberCount() {
        List<Arguments> listOfArguments = new ArrayList<>();
        listOfArguments.add(Arguments.of(Arrays.asList(8, 21, 23, 41, 42, 43), Arrays.asList(8, 21, 23, 41, 42, 43), 6));
        listOfArguments.add(Arguments.of(Arrays.asList(8, 21, 23, 41, 42, 43), Arrays.asList(8, 21, 23, 41, 42, 44), 5));
        listOfArguments.add(Arguments.of(Arrays.asList(8, 21, 23, 41, 42, 43), Arrays.asList(8, 21, 23, 40, 42, 44), 4));
        listOfArguments.add(Arguments.of(Arrays.asList(8, 21, 23, 41, 42, 43), Arrays.asList(1, 21, 23, 40, 42, 44), 3));
        listOfArguments.add(Arguments.of(Arrays.asList(8, 21, 23, 41, 42, 43), Arrays.asList(1, 2, 3, 4, 5, 6), 0));
        return listOfArguments.stream();
    }

}