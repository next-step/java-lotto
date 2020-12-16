package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.Lotto;
import step2.domain.LottoGenerator;
import step2.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step2.domain.Lotto.LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE;
import static step2.domain.Lotto.LOTTO_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE;

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

    @DisplayName("입력받은 로또와 비교하여 LottoTier를 반환한다.")
    @ParameterizedTest
    @MethodSource("getTargetNumbers")
    void getLottoTier(List<Integer> input, LottoTier expected) {
        Lotto winningLotto = LottoGenerator.generateLotto(Arrays.asList(1, 2, 3, 4 ,5 ,6));
        Lotto inputLotto = LottoGenerator.generateLotto(input);

        assertThat(inputLotto.getLottoTier(winningLotto)).isEqualTo(expected);
    }

    private static Stream<Arguments> getTargetNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), LottoTier.FIRST),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), LottoTier.SECOND),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 7, 8), LottoTier.THIRD),
                Arguments.of(Arrays.asList(1, 2, 3, 7, 8, 9), LottoTier.FOURTH),
                Arguments.of(Arrays.asList(1, 2, 7, 8, 9, 10), LottoTier.NONE),
                Arguments.of(Arrays.asList(1, 7, 8, 9, 10, 11), LottoTier.NONE),
                Arguments.of(Arrays.asList(7, 8, 9, 10, 11, 12), LottoTier.NONE)
        );
    }
}
