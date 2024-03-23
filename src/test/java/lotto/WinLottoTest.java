package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.domain.WinLotto;
import lotto.exception.AlreadyExistLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinLottoTest {

    @Test
    @DisplayName("[성공] 당첨 번호 정보를 가진 WinLotto 인스턴스를 생성한다.")
    void 당첨_로또() {
        assertThatCode(() -> {
            new WinLotto(new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6))), new LottoNumber(45));
        }).doesNotThrowAnyException();
    }


    @Test
    @DisplayName("[실패] 이미 있는 로또 번호로 보너스 볼을 생성한 경우 IllegalExistBonusLottoNumberException 예외가 발생한다.")
    void 이미_있는_로또_번호() {
        assertThatExceptionOfType(AlreadyExistLottoNumberException.class)
                .isThrownBy(() -> new WinLotto(new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6))), new LottoNumber(6)))
                .withMessageContaining("이미 입력된 당첨 번호입니다. (당첨 번호: [1, 2, 3, 4, 5, 6], 보너스 번호: 6)");
    }

}
