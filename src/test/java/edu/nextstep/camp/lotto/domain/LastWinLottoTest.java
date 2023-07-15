package edu.nextstep.camp.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LastWinLottoTest {

    @Test
    void 보너스_번호_로또_번호_중복_체크() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LastWinLotto(new Lotto(2, 3, 4, 5, 6, 7), LottoNumber.of(2))
        ).withMessageContaining("보너스 번호는 지난주 로또 번호와 겹칠 수 없습니다.");
    }

    @Test
    void 로또_번호_기반_등수_확인() {
        LastWinLotto lastWinLotto = new LastWinLotto(new Lotto(2, 3, 4, 5, 6, 7), LottoNumber.of(9));

        LottoRank lottoRank = lastWinLotto.checkRank(new Lotto(2, 3, 4, 5, 6, 9));

        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }
}
