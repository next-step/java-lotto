package step2.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.model.LottoNumber;
import step2.model.PurchasedLottoTicket;
import step2.model.WinningLottoTicket;

class AutomaticLottoGeneratorTest {
    @DisplayName("로또 생성 테스트")
    @Test
    public void generateLottoTest() {
        assertThatCode(PurchasedLottoTicket::create).doesNotThrowAnyException();
    }

    @DisplayName("로또 번호 생성 테스트")
    @Test
    public void generateLottoNumberTest() {
        PurchasedLottoTicket purchasedLottoTicket = PurchasedLottoTicket.create();
        assertThat(purchasedLottoTicket.getNumbers())
            .hasSize(PurchasedLottoTicket.LOTTO_NUMBER_SIZE)
            .allMatch(number -> number.toInt() >= LottoNumber.LOTTO_MIN_NUMBER && number.toInt() <= LottoNumber.LOTTO_MAX_NUMBER);
    }

    @DisplayName("로또 생성 오류 테스트")
    @ParameterizedTest
    @MethodSource("generateLottoExceptionTestCases")
    public void generateLottoExceptionTest(List<Integer> numbers) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> WinningLottoTicket.createBy(numbers))
            .withMessageContaining("로또의 수 범위는 1 ~ 45 까지의 입니다.");
    }

    private static Stream<Arguments> generateLottoExceptionTestCases() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 70)),
            Arguments.of(Arrays.asList(-10, 2, 3, 9, 5, 6))
        );
    }
}