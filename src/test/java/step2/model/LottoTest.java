package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("정적 생성자는 로또 번호의 개수가 6개가 아니면 예외 발생")
    @MethodSource("provideLottoNumbersForCreate")
    @ParameterizedTest(name = "로또 번호:: {0}")
    void createInvalidRange(List<LottoNumber> lottoNumbers) {
        assertThatThrownBy(() -> Lotto.create(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideLottoNumbersForCreate() {
        return Stream.of(
                Arguments.of(LottoData.createLottoNumbers(5)),
                Arguments.of(LottoData.createLottoNumbers(7))
        );
    }

    @DisplayName("정적 생성자는 중복 번호가 존재하면 예외 발생")
    @Test
    void createDuplicateNumber() {
        int duplicateNumber = 1;
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(i -> LottoNumber.valueOf(duplicateNumber))
                .collect(Collectors.toList());

        assertThatThrownBy(() -> Lotto.create(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 존재하면 true 반환")
    @Test
    void containsNumberExistNumber() {
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
        Lotto lotto = Lotto.create(lottoNumbers);

        lottoNumbers.forEach(lottoNumber -> assertThat(lotto.containsNumber(lottoNumber)).isTrue());
    }

    @DisplayName("로또 번호가 존재하지 않으면 false 반환")
    @Test
    void containsNumberNonExistNumber() {
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
        Lotto lotto = Lotto.create(lottoNumbers);

        assertThat(lotto.containsNumber(LottoNumber.valueOf(7))).isFalse();
    }
}
