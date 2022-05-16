package study.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("번호 그룹")
class LottoNumbersTest {
    private static Stream<Arguments> createLottoNumber() {
        return Stream.of(
                Arguments.of(IntStream.range(1,7)
                        .boxed()
                        .collect(Collectors.toSet()))
        );
    }

    @ParameterizedTest
    @DisplayName("번호 사이즈 6개 확인")
    @MethodSource("createLottoNumber")
    void 번호_사이즈_6개_확인(Set<Integer> lottoNumber) {
        LottoNumbers numbers = new LottoNumbers(lottoNumber);

        assertThat(numbers.readOnlyNumbers().size()).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("번호 일치 확인")
    @MethodSource("createLottoNumber")
    void 번호_일치_확인(Set<Integer> lottoNumber) {
        Set<Integer> intList = lottoNumber;
        LottoNumbers numbers = new LottoNumbers(intList);
        LottoNumbers numbers2 = new LottoNumbers(intList);

        assertThat(numbers.equals(numbers2)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("번호 불일치 확인")
    @MethodSource({"createLottoNumber"})
    void 번호_불일치_확인(Set<Integer> lottoNumber) {
        LottoNumbers numbers = new LottoNumbers(lottoNumber);
        LottoNumbers numbers2 = new LottoNumbers(IntStream.range(2, 8)
                .boxed()
                .collect(Collectors.toSet()));

        assertThat(numbers.equals(numbers2)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,", "1,2,3,4,5"})
    @DisplayName("번호 6개 미만 예외 확인")
    void 번호_6개_미만_예외_확인(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoMachine.createLottoTicket(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,45", "1,2,3,4,5,46"})
    @DisplayName("로또 번호 1 ~ 45 벗어날 시 예외 확인")
    void 로또번호_1_45_벗어날_시_예외_확인(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->{
            LottoMachine.createLottoTicket(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "1,1,1,1,1,1"})
    @DisplayName("로또 번호 중복 예외 확인")
    void 로또번호_중복예외_확인(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoMachine.createLottoTicket(input);
        });
    }
}