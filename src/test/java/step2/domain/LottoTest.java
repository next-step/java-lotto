package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.exception.LottoCountBoundException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또 한장을 만듭니다.")
    void create() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.lottoNumbersSize()).isEqualTo(6);
    }

    @ParameterizedTest
    @MethodSource("createExceptionLotto")
    @DisplayName("로또 티켓 한장을 만들때 갯수가 넘거나 적으면 익셉션을 도출합니다.")
    void validLotto(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(LottoCountBoundException.class);
    }

    private static Stream<Arguments> createExceptionLotto() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }
}
