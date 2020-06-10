package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("로또 티켓 클래스 리스트")
class LottoTicketTest {

    @Test
    @DisplayName("로또 번호 입력 후 확인 테스트")
    void settingLottoNumberTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoTicket lottoTicket = new LottoTicket(numbers);

        assertThat(lottoTicket.getNumbers()).isEqualTo(lottoTicket.getNumbers());
    }

    @Test
    @DisplayName("로또 번호 검증 테스트")
    void validateLottoNumberTest() {
        List<Integer> validationTarget1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(validationTarget1));

        List<Integer> validationTarget2 = Arrays.asList(1, 2, 3, 4, 5, -3);
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(validationTarget2));


    }
}