package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.TestLottoNumberFactory;
import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.InvalidSizeOfLottoException;
import lotto.exception.UnsortedLottoNumbersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    private static final int SIZE_OF_LOTTO = 6;

    @DisplayName("유효한 갯수의 숫자를 가진 로또 티켓을 생성할 수 있다.")
    @Test
    void createValidLottoTicket() {
        LottoTicket lottoTicket = LottoTicket.of(
                TestLottoNumberFactory.createLottoNumbers(1, 2, 3, 4, 5 ,6)
        );
        assertThat(lottoTicket.toString().split(",")).hasSize(SIZE_OF_LOTTO);
    }

    @DisplayName("유효하지 않은 갯수의 로또 번호가 들어오는 경우 예외가 발생한다.")
    @Test
    void throwWhenExceptionWhenInvalidLottoSize() {
        List<LottoNumber> lottoNumbers = TestLottoNumberFactory.createLottoNumbers(1, 2, 3, 4);

        assertThatThrownBy(() -> LottoTicket.of(lottoNumbers))
                .isInstanceOf(InvalidSizeOfLottoException.class)
                .hasMessage("로또 번호 갯수 오류입니다.");
    }

    @DisplayName("로또 번호가 정렬되지 않은 경우 예외가 발생한다.")
    @Test
    void throwWhenExceptionWhenUnSorted() {
        List<LottoNumber> lottoNumbers =  TestLottoNumberFactory.createLottoNumbers(6, 2, 3, 4, 1, 5);

        assertThatThrownBy(() -> LottoTicket.of(lottoNumbers))
                .isInstanceOf(UnsortedLottoNumbersException.class)
                .hasMessage("로또 번호는 정렬된 상태여야 합니다.");
    }

    @DisplayName("중복된 번호가 존재하는 경우 예외가 발생한다.")
    @Test
    void throwWhenExceptionWhenDuplicate() {
        List<LottoNumber> lottoNumbers = TestLottoNumberFactory.createLottoNumbers(1, 1, 3, 4, 5, 6);

        assertThatThrownBy(() -> LottoTicket.of(lottoNumbers))
                .isInstanceOf(DuplicateLottoNumberException.class)
                .hasMessage("중복된 로또 번호가 존재합니다.");
    }

    @Test
    @DisplayName("로또 번호 일치 여부 확인")
    void matchLottoNumber() {
        LottoTicket lottoTicket = LottoTicket.of(
                TestLottoNumberFactory.createLottoNumbers(1, 2, 3, 4, 5 ,6)
        );
        assertThat(lottoTicket.match(LottoNumber.of(1))).isTrue();
        assertThat(lottoTicket.match(LottoNumber.of(7))).isFalse();
    }

}
