package lotto.backend.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningLottoTest {

    @DisplayName("당첨 로또번호에 보너스번호가 포함되있으면 Error")
    @ParameterizedTest(name = "[{index}} 로또번호: [1,2,3,4,5,6] 보너스번호: {0} => error")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void check_bonus_number(int bonusNum) {
        LottoTicket lottoTicket = LottoTicket.create(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = new LottoNumber(bonusNum);
        assertThrows(IllegalArgumentException.class
                , () -> new WinningLotto(lottoTicket, lottoNumber));
    }
}
