package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    @DisplayName("로또는 반드시 6개의 번호로 이루어져야 한다")
    public void invalidLottoWhenInputNumbersCountLessThenSix() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(Collections.emptyList()));
    }

    @Test
    @DisplayName("로또 번호는 중복될 수 없다")
    public void invalidLottoWhenInputDuplicatedNumbers() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 3, 4, 5)));
    }

    @ParameterizedTest
    @MethodSource("provideIntList")
    @DisplayName("입력된 로또와 당첨 로또의 일치하는 번호 갯수를 리턴한다")
    public void matchLottoNumberReturnsCountOfMatches(List<Integer> lottoNumbers,
                                                      List<Integer> winningLottoNumbers,
                                                      int expected) {
        Lotto lotto = new Lotto(lottoNumbers);
        Lotto winningLotto = new Lotto(winningLottoNumbers);
        int result = lotto.match(winningLotto);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideIntList() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 10, 11, 12), Arrays.asList(1, 2, 3, 4, 5, 6), 3),
                Arguments.of(Arrays.asList(1, 2, 3, 10, 11, 12), Arrays.asList(1, 2, 3, 5, 6, 10), 4)
        );
    }
}
