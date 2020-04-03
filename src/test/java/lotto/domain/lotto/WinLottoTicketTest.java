package lotto.domain.lotto;

import lotto.exception.ValidLottoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinLottoTicketTest {

    private List<LottoNumber> numbers;
    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        lottoNumbers = new LottoNumbers(numbers);
    }

    @DisplayName("당첨 로또를 생성 한다.")
    @Test
    public void constructor_success() throws Exception {
        //given
        WinLottoTicket winTicket = new WinLottoTicket(lottoNumbers, new LottoNumber(7));
        WinLottoTicket winTicket2 = new WinLottoTicket(lottoNumbers, new LottoNumber(7));

        //then
        assertThat(winTicket.equals(winTicket2)).isTrue();
    }

    @DisplayName("당첨 로또의 번호 6개와 추가 보너스 번호 1개가 중복되선 안된다")
    @Test
    public void validateBonusNumber_fail() throws Exception {
        assertThatThrownBy(
                () -> new WinLottoTicket(lottoNumbers, new LottoNumber(6))
        ).isInstanceOf(ValidLottoException.class);
    }
}
