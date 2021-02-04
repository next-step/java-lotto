package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTicketTest {

    @DisplayName("생성자의 인자로 들어온 LottoNumbers의 size가 6이 아니면 exception 발생")
    @Test
    void notRequiredSizedLottoNumbersThrowsException() {
        // given
        List<LottoNumber> lottoNumbers = createFiveLottoNumbers();

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> new LottoTicket(lottoNumbers));
    }

    @DisplayName("중복된 번호가 있으면 exception 발생")
    @Test
    void duplicateElementsThrowException() {
        // given
        List<LottoNumber> lottoNumbers = createLottoNumbersWithDuplicate();

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new LottoTicket(lottoNumbers));
        assertThat(exception.getMessage()).isEqualTo("중복된 번호가 존재합니다.");
    }

    @DisplayName("toString() 결과 포맷")
    @Test
    void toStringTest() {
        // given
        List<LottoNumber> lottoNumbers = createNormalLottoNumbers();
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        // when
        String result = lottoTicket.toString();

        // then
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    private List<LottoNumber> createFiveLottoNumbers() {
        return Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5)
        );
    }

    private List<LottoNumber> createLottoNumbersWithDuplicate() {
        return Arrays.asList(
                LottoNumber.of(3),
                LottoNumber.of(5),
                LottoNumber.of(11),
                LottoNumber.of(25),
                LottoNumber.of(5),
                LottoNumber.of(39)
        );
    }

    private List<LottoNumber> createNormalLottoNumbers() {
        return Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
    }
}