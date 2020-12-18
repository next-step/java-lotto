package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTicketTest {
    private final Set<Integer> lottoNumbers = new HashSet<>();

    @BeforeEach
    void setUp() {
        lottoNumbers.add(3);
        lottoNumbers.add(6);
        lottoNumbers.add(9);
        lottoNumbers.add(12);
        lottoNumbers.add(15);
    }

    @DisplayName("로또 번호 중복 여부 유효성")
    @Test
    void failureByDuplicatedNumbers() {
        lottoNumbers.add(15);
        assertThatIllegalArgumentException().isThrownBy(() -> LottoTicket.validateMoreThanSix(lottoNumbers));
        lottoNumbers.remove(15);
    }

    @DisplayName("로또 번호 6개 이하인 경우")
    @Test
    void failureByLessThanNumbers() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoTicket.validateMoreThanSix(lottoNumbers));
    }

    @DisplayName("로또 번호가 Empty 여부 유효성")
    @ParameterizedTest
    @ValueSource(strings = {" ",""})
    void validateEmptyOrNullNumbers(String inputLottoNumbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoTicket.validateNullOrEmpty(inputLottoNumbers));
    }

    @DisplayName("로또 번호가 6자리인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"2,4,6,8,10,12"})
    void validateNumbers(String inputLottoNumbers) {
        assertThat(LottoTicket.validateNullOrEmpty(inputLottoNumbers)).isEqualTo(inputLottoNumbers);
        lottoNumbers.add(18);
        assertThatCode(()->LottoTicket.validateMoreThanSix(lottoNumbers)).doesNotThrowAnyException();
        lottoNumbers.remove(18);
    }

    @DisplayName("로또 번호가 1~45 을 넘을 경우")
    @ParameterizedTest
    @MethodSource("numberOfLotto")
    void failureByBoundaryNumbers(Integer number) {
        lottoNumbers.add(number);
        assertThatIllegalArgumentException().isThrownBy(() -> LottoTicket.validateInputNumberMaxAndMin(lottoNumbers));
        lottoNumbers.remove(number);
    }

    private static Stream<Arguments> numberOfLotto() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(46)
        );
    }
}