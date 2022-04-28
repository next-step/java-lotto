package lotto.domain;

import lotto.exception.InvalidLottoTicketException;
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
        LottoTicket lotto = getLottoTicket(lottoNumbers);
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
        assertThatThrownBy(() -> getLottoTicket(lottoNumbers))
                .isInstanceOf(InvalidLottoTicketException.class);
    }

    @Test
    @DisplayName("일치하는 숫자 개수 확인")
    void countMatchNumbers() {
        // given
        Set<LottoNumber> lottoNumbers = Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        Set<LottoNumber> lottoNumbers_expect5 = Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(7)
        );
        Set<LottoNumber> lottoNumbers_expect0 = Set.of(
                new LottoNumber(11),
                new LottoNumber(21),
                new LottoNumber(31),
                new LottoNumber(41),
                new LottoNumber(15),
                new LottoNumber(17)
        );
        // when, then
        assertThat(getLottoTicket(lottoNumbers).countMatchNumbers(getLottoTicket(lottoNumbers))).isEqualTo(6);
        assertThat(getLottoTicket(lottoNumbers).countMatchNumbers(getLottoTicket(lottoNumbers_expect5))).isEqualTo(5);
        assertThat(getLottoTicket(lottoNumbers).countMatchNumbers(getLottoTicket(lottoNumbers_expect0))).isEqualTo(0);

    }

    private LottoTicket getLottoTicket(Set<LottoNumber> lottoNumbers1) {
        return new LottoTicket(lottoNumbers1);
    }

}
