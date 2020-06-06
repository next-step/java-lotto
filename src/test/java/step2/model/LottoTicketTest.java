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
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTicketTest {

    @DisplayName("create() 정적 생성자는 로또 번호의 개수가 6개가 아니면 예외를 발생한다")
    @MethodSource("provideLottoNumbersForCreate")
    @ParameterizedTest(name = "로또 번호:: {0}")
    void create_LottoNumbers_ExceptionThrown(List<LottoNumber> lottoNumbers) {
        assertThatThrownBy(() -> LottoTicket.create(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideLottoNumbersForCreate() {
        return Stream.of(
                Arguments.of(LottoData.createLottoNumbers(5)),
                Arguments.of(LottoData.createLottoNumbers(7))
        );
    }

    @DisplayName("create() 정적 생성자는 중복 번호가 존재하면 예외를 발생한다.")
    @Test
    void create_LottoNumbers_ExceptionThrown() {
        int duplicateNumber = 1;
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(i -> LottoNumber.valueOf(duplicateNumber))
                .collect(Collectors.toList());

        assertThatThrownBy(() -> LottoTicket.create(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("getLottoNumbers() 메소드는 입력한 로또번호 리스트를 반환한다")
    @Test
    void getLottoNumbers_None_LottoNumbers() {
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.generate();
        LottoTicket lottoTicket = LottoTicket.create(lottoNumbers);

        assertThat(lottoTicket.getLottoNumbers()).isEqualTo(lottoNumbers);
    }

    @DisplayName("getLottoNumbers() 에서 반환된 로또번호 리스트를 수정하면 예외가 발생한다")
    @Test
    void getLottoNumbers_None_ExceptionThrown() {
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.generate();
        LottoTicket lottoTicket = LottoTicket.create(lottoNumbers);

        List<LottoNumber> unmodifiableLottoNumbers = lottoTicket.getLottoNumbers();

        assertThatThrownBy(() -> unmodifiableLottoNumbers.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("containsNumber() 메서드는 로또 번호가 존재하면 TRUE를 반환한다")
    @Test
    void containsBonus_LottoNumber_True() {
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
        LottoTicket lottoTicket = LottoTicket.create(lottoNumbers);

        lottoNumbers.forEach(lottoNumber -> assertThat(lottoTicket.containsNumber(lottoNumber)).isTrue());
    }

    @DisplayName("containsNumber() 메서드는 로또 번호가 존재하지 않으면 False를 반환한다")
    @Test
    void containsBonus_LottoNumber_False() {
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
        LottoTicket lottoTicket = LottoTicket.create(lottoNumbers);

        assertThat(lottoTicket.containsNumber(LottoNumber.valueOf(7))).isFalse();
    }
}
