package lotto.domain;

import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @Test
    @DisplayName("로또는 6개의 로또 숫자를 갖는다")
    void lottoSizeTest() {
        // given
        Set<LottoNumber> lottoNumbers = Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        // when
        LottoTicket lotto = new LottoTicket(lottoNumbers);
        // then
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("6개가 아닌 로또 숫자를 갖으면 InvalidLottoException 발생")
    void throwInvalidLottoExceptionTest() {
        // given
        Set<LottoNumber> lottoNumbers = Set.of(
                new LottoNumber(1),
                new LottoNumber(2)
        );
        // when, then
        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(InvalidLottoException.class);
    }

}
