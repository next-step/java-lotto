package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {
    @Test
    void 로또숫자_생성() {
        LottoNumber lottoNumber = new LottoNumber(3);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, -2, 100})
    void 범위를_벗어난_로또숫자_생성(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(number));
    }

    @Test
    void 로또숫자_비교() {
        LottoNumber lottoNumber = new LottoNumber(3);
        assertThat(lottoNumber.compareTo(new LottoNumber(6))).isNegative();
    }

    @Test
    void 보너스볼_생성() {
        LottoTicket winningNumbers = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusBall = LottoNumber.createBonusBall(winningNumbers, "7");
        assertThat(bonusBall).isEqualTo(new LottoNumber(7));
    }

    @Test
    void 잘못된_보너스볼_생성() {
        LottoTicket winningNumbers = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.createBonusBall(winningNumbers, "3"));
    }
}
