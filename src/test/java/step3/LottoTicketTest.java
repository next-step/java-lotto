package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("로또 티켓 클래스 리스트")
class LottoTicketTest {

    @Test
    @DisplayName("로또 번호 입력 후 확인 테스트")
    void settingLottoNumberTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoTicket lottoTicket = LottoTicket.newLottoTicket(numbers);

        assertThat(lottoTicket.getNumbers()).isEqualTo(lottoTicket.getNumbers());
    }

    @ParameterizedTest
    @MethodSource("provideFaultLottoNumberList")
    @DisplayName("로또 번호 검증 테스트")
    void validateLottoNumberTest(List<Integer> input) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoTicket.newLottoTicket(input));
    }

    private static Stream<Arguments> provideFaultLottoNumberList() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6,7)),
                Arguments.of(Arrays.asList(1,2,3,4,5,-6))
        );
    }


    @Test
    @DisplayName("맞춤 개수가 몇개인지 확인하는 테스트")
    void 숫자_몇개_맞췄나() {

        LottoTicket lottoTicket = LottoTicket.newLottoTicket(Arrays.asList(1,2,3,4,5,6));
        LottoTicket winningNumbersTicket = LottoTicket.newLottoTicketFromString("1,2,3,4,11,12");
        List<Integer> winningCountList = winningNumbersTicket.checkLottoWinning(Collections.singletonList(lottoTicket));

        assertThat(4).isEqualTo(winningCountList.get(0));
    }

    @Test
    @DisplayName("정적팩토리메서드 확인 테스트")
    void newLottoTicketTesT() {
        LottoTicket target1 = LottoTicket.newLottoTicket(Arrays.asList(1,2,3,4,5,6));
        LottoTicket target2 = LottoTicket.newLottoTicketFromString("1,2,3,4,5,6");

        assertThat(target1.getNumbers()).hasSize(6);
        assertThat(target2.getNumbers()).hasSize(6);
    }

}