package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.lotto.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("로또")
class LottoTest {

    public static Stream<Arguments> notValidLottoNumbers() {
        return Stream.of(
            Arguments.of(Arrays.asList(0, 1, 2, 3, 4, 5)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 5)),
            Arguments.of(Arrays.asList(0, 5, 6, 7, 15, 46)),
            Arguments.of(Arrays.asList(1, 2, 6, 7))
        );
    }

    @DisplayName("[실패] 중복된 숫자")
    @ParameterizedTest
    @MethodSource("notValidLottoNumbers")
    public void create_duplicateNumber(List<Integer> numbers) {
        // given

        // when
        assertThrows(InvalidLottoNumberException.class, () -> new NormalLotto(numbers));

        // then

    }
}
