package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoNumbersTest {

    @Test
    void 랜덤으로_로또번호를_생성한다() {
        assertThatNoException().isThrownBy(LottoNumbers::new);
    }

    @Test
    void 한_게임에_로또번호는_6개다() {
        assertThatNoException().isThrownBy(() -> new LottoNumbers("1,2,3,4,5,6"));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 7, 10})
    void 한_게임에_로또번호는_6개다(int count) {
        List<String> inputList = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            inputList.add(String.valueOf(i));
        }

        String input = String.join(",", inputList);

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(input))
                .withMessage("중복되지 않은 6개의 로또번호가 필요합니다.");
    }

    @Test
    void 입력값으로_당첨번호를_생성한다() {
        assertThatNoException().isThrownBy(() -> new LottoNumbers("1,2,3,4,5,6"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 당첨번호는_필수다(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(input))
                .withMessage("당첨번호를 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,,,3,4,5,6", "1,나,3,4,5,6"})
    @DisplayName("당첨 번호는 쉼표로 구분된 숫자만 입력 가능하다.")
    void 당첨_번호_확인(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(input))
                .withMessage("숫자만 입력할 수 있습니다.");
    }

    @ParameterizedTest
    @MethodSource("compareIdenticalNumber")
    void 같은_번호의_갯수를_반환한다(String numbers1, String numbers2, int expected) {
        LottoNumbers lottoNumbers1 = new LottoNumbers(numbers1);
        LottoNumbers lottoNumbers2 = new LottoNumbers(numbers2);

        assertThat(lottoNumbers1.countIdenticalLottoNumberSet(lottoNumbers2)).isEqualTo(expected);
    }

    private static Stream<Arguments> compareIdenticalNumber() {
        return Stream.of(
                Arguments.arguments("1,2,3,4,5,6", "1,2,3,4,5,6", 6),
                Arguments.arguments("1,2,3,4,5,6", "1,2,3,4,5,7", 5),
                Arguments.arguments("1,2,3,4,5,6", "1,2,3,4,7,8", 4),
                Arguments.arguments("1,2,3,4,5,6", "1,2,3,7,8,9", 3),
                Arguments.arguments("1,2,3,4,5,6", "1,2,7,8,9,10", 2),
                Arguments.arguments("1,2,3,4,5,6", "1,7,8,9,10,11", 1),
                Arguments.arguments("1,2,3,4,5,6", "7,8,9,10,11,12", 0)
        );
    }

    @Test
    @DisplayName("toString() 은[번호, 번호] 형식의 문자열을 반환한다.")
    void toString은_게임_내_숫자를_반환한다() {
        LottoNumbers game = new LottoNumbers("1,2,3,4,5,6");

        assertThat(game).hasToString("[1, 2, 3, 4, 5, 6]");
    }
}
