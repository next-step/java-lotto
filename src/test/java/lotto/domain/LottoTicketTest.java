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
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        );

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> new LottoTicket(lottoNumbers));
    }

    @DisplayName("toString() 결과 포맷")
    @Test
    void toStringTest() {
        // given
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        // when
        String result = lottoTicket.toString();

        // then
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}