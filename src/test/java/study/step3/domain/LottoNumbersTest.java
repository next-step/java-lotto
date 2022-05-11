package study.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("번호 그룹")
class LottoNumbersTest {
    public List<Integer> createLottoNumber() {
        return IntStream.range(1,7)
                .boxed()
                .collect(Collectors.toList());
    }
    public List<Integer> createLottoNumber_2() {
        return IntStream.range(2, 8)
                .boxed()
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("번호 사이즈 6개 확인")
    void 번호_사이즈_6개_확인() {
        // given
        LottoNumbers numbers = new LottoNumbers(createLottoNumber());
        // when
        // then
        assertThat(numbers.readOnlyNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("번호 일치 확인")
    void 번호_일치_확인() {
        // given
        List<Integer> intList = createLottoNumber();
        LottoNumbers numbers = new LottoNumbers(intList);
        LottoNumbers numbers2 = new LottoNumbers(intList);
        // when
        // then
        assertThat(numbers.equals(numbers2)).isTrue();
    }

    @Test
    @DisplayName("번호 불일치 확인")
    void 번호_불일치_확인() {
        // given
        LottoNumbers numbers = new LottoNumbers(createLottoNumber());
        LottoNumbers numbers2 = new LottoNumbers(createLottoNumber_2());
        // when
        // then
        assertThat(numbers.equals(numbers2)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,", "1,2,3,4,5"})
    @DisplayName("번호 6개 미만 예외 확인")
    void 번호_6개_미만_예외_확인(String input) {
        // given
        // when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoMachine.createLottoTicket(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,45", "1,2,3,4,5,46"})
    @DisplayName("로또 번호 1 ~ 45 벗어날 시 예외 확인")
    void 로또번호_1_45_벗어날_시_예외_확인(String input) {
        // given
        // when, then
        assertThatIllegalArgumentException().isThrownBy(() ->{
            LottoMachine.createLottoTicket(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "1,1,1,1,1,1"})
    @DisplayName("로또 번호 중복 예외 확인")
    void 로또번호_중복예외_확인(String input) {
        // given
        // when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoMachine.createLottoTicket(input);
        });
    }
}