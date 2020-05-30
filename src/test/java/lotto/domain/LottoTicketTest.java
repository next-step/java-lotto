package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    private LottoTicket lottoTicket = LottoTicketFactory.createManualLottoTicket("1, 2, 3, 4, 5, 6");

    @DisplayName("로또 번호가 없으면 로또 번호를 생성할 수 없다.")
    @Test
    void canNotCreateLottoNumbersIfLottoNumbersIsNull() {
        assertThatThrownBy(() -> LottoTicket.newManualLottoTicket(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoTicket.newAutoLottoTicket(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoTicket.newWinLottoTicket(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개가 아니면 로또 번호를 생성할 수 없다.")
    @ParameterizedTest
    @MethodSource("generateInvalidLottoNumbers")
    void canNotCreateLottoNumbersIfUnless6LottoNumbers(List<LottoNumber> numbers) {
        assertThatThrownBy(() -> LottoTicket.newManualLottoTicket(numbers))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoTicket.newAutoLottoTicket(numbers))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoTicket.newWinLottoTicket(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateInvalidLottoNumbers() {
        return Stream.of(
                Arguments.of(NumbersFactory.createManualNumbers("1, 2, 3, 4, 5")),
                Arguments.of(NumbersFactory.createManualNumbers("1, 2, 3, 4, 5, 6, 7"))
        );
    }

    @DisplayName("중복된 번호가 있으면 로또 번호를 생성할 수 없다.")
    @Test
    void canNotCreateLottoNumbersIfContainDuplicateNumbers() {
        assertThatThrownBy(() -> {
            List<LottoNumber> manualNumbers = LottoTicket.createNonDuplicateNumbers("1, 2, 3, 4, 5, 5");
            LottoTicket.newManualLottoTicket(manualNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 생성할 수 있다.")
    @Test
    void canCreateLottoNumbers() {
        assertThat(this.lottoTicket).isInstanceOf(LottoTicket.class);
    }

    @DisplayName("로또 번호를 출력할 수 있다.")
    @Test
    void canPrintLottoNumbersToString() {
        assertThat(this.lottoTicket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("다른 로또 번호와 일치하는 번호 개수를 구할 수 있다.")
    @Test
    void canGetMatchCountOtherLottoNumbers() {
        List<LottoNumber> manualNumbers = LottoTicket.createNonDuplicateNumbers("1, 2, 4, 9, 11, 26");
        LottoTicket lotto = LottoTicket.newManualLottoTicket(manualNumbers);
        assertThat(this.lottoTicket.getMatchCount(lotto)).isEqualTo(3);
    }

    @DisplayName("중복되지 않은 숫자를 생성할 수 있다.")
    @ParameterizedTest
    @MethodSource("generateLottoNumbers")
    void canCreateNonDuplicateNumbers(List<LottoNumber> nonDuplicateNumbers) {
        assertThat(nonDuplicateNumbers).isNotNull();
        assertThat(nonDuplicateNumbers).hasSize(6);
    }

    static Stream<Arguments> generateLottoNumbers() {
        return Stream.of(
                Arguments.of(LottoTicket.createNonDuplicateNumbers()),
                Arguments.of(LottoTicket.createNonDuplicateNumbers("1, 2, 3, 4, 5, 6"))
        );
    }

    @DisplayName("로또 번호에 특정 번호가 포함되어 있는지 알 수 있다.")
    @ParameterizedTest
    @MethodSource("generateLottoNumber")
    void canContainsMatchNumber(LottoNumber lottoNumber, boolean result) {
        assertThat(this.lottoTicket.isMatchNumber(lottoNumber)).isEqualTo(result);
    }

    static Stream<Arguments> generateLottoNumber() {
        return Stream.of(
                Arguments.of(LottoNumber.newInstance(1), true),
                Arguments.of(LottoNumber.newInstance(2), true),
                Arguments.of(LottoNumber.newInstance(3), true),
                Arguments.of(LottoNumber.newInstance(4), true),
                Arguments.of(LottoNumber.newInstance(5), true),
                Arguments.of(LottoNumber.newInstance(6), true),
                Arguments.of(LottoNumber.newInstance(7), false)
        );
    }

    @DisplayName("객체를 복사할 수 있다.")
    @Test
    void canClone() {
        LottoTicket clonedLottoTicket = this.lottoTicket.clone();
        assertThat(this.lottoTicket).isNotEqualTo(clonedLottoTicket);
    }

    @DisplayName("특정 생성 유형과 같은지 확인할 수 있다.")
    @Test
    void canEqualsCreationType() {
        assertThat(this.lottoTicket.equalsCreationType(CreationType.MANUAL)).isTrue();
    }
}
