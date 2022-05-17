package lotto.domain;

import lotto.exceptions.DuplicateLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @Test
    @DisplayName("이번주 우승 로또 번호와, 보너스볼의 번호는 중복이 될 수 없다.")
    void winningLotto() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );

        assertThatThrownBy(() -> new WinningLotto(new LottoTicket(lottoNumbers), new LottoNumber(6)))
                .isInstanceOf(DuplicateLottoNumberException.class);
    }
}
