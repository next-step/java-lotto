package lotto.model;

import lotto.model.wrapper.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("로또 한장 테스트")
public class LottoTicketTests {

    @DisplayName("로또 생성 테스트")
    @Test
    public void generateLottoTest() {
        assertThatCode(LottoTicket::newInstance).doesNotThrowAnyException();
    }

    @DisplayName("로또 생성 오류 테스트 - 숫자 갯수가 6개가 아니거나, 중복되는 숫자가 있을 경우")
    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("generateLottoExceptionTestCases")
    public void generateLottoExceptionTest(Set<LottoNumber> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.newInstance(numbers))
                .withMessageContaining("로또는 서로 다른 6개의 숫자여야 합니다.");
    }

    private static Stream<Arguments> generateLottoExceptionTestCases() {
        return Stream.of(
                Arguments.of(new HashSet<>(Arrays.asList(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6), LottoNumber.of(7)))),
                Arguments.of(new HashSet<>(Arrays.asList(
                        LottoNumber.of(1), LottoNumber.of(2),
                        LottoNumber.of(3), LottoNumber.of(4)))),
                Arguments.of(new HashSet<>(Arrays.asList(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4),
                        LottoNumber.of(3), LottoNumber.of(4))))
        );
    }

}
