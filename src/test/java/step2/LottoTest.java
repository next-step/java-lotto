package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.peer.TextAreaPeer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static step2.Lotto.LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE;
import static step2.Lotto.LOTTO_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE;

public class LottoTest {

    @Test
    @DisplayName("로또번호를 통해 Lotto 객체 생성시, 중복된 숫자는 없는지 검증한다.")
    void assertNumbers_duplicate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(3));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).withMessage(LOTTO_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("로또번호를 통해 Lotto 객체 생성시, 숫자 개수가 6개인지 검증한다.")
    void assertNumbers_count() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).withMessage(LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE);
    }

    @DisplayName("입력받은 로또와 몇 개의 숫자가 일치하는 지 반환한다.")
    @ParameterizedTest
    @MethodSource("getTargetNumbers")
    void getMatchingCount(List<Integer> input, int expected) {
        Lotto winningLotto = LottoGenerator.generateLotto(Arrays.asList(1, 2, 3, 4 ,5 ,6));

        assertThat(winningLotto.getMatchingCount(LottoGenerator.generateLotto(input))).isEqualTo(expected);
    }

    private static Stream<Arguments> getTargetNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 7, 8), 4),
                Arguments.of(Arrays.asList(1, 2, 3, 7, 8, 9), 3),
                Arguments.of(Arrays.asList(1, 2, 7, 8, 9, 10), 2),
                Arguments.of(Arrays.asList(1, 7, 8, 9, 10, 11), 1),
                Arguments.of(Arrays.asList(7, 8, 9, 10, 11, 12), 0)
        );
    }
}
