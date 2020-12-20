package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step4.domain.Lotto;
import step4.domain.LottoNumber;
import step4.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    private List<LottoNumber> lottoNumbers = new ArrayList<>();
    private Lotto lotto;
    private WinningLotto winningLotto;

    @BeforeEach
    void init() {
        lottoNumbers.add(LottoNumber.of(1));
        lottoNumbers.add(LottoNumber.of(2));
        lottoNumbers.add(LottoNumber.of(3));
        lottoNumbers.add(LottoNumber.of(4));
        lottoNumbers.add(LottoNumber.of(5));
        lottoNumbers.add(LottoNumber.of(6));

        lotto = new Lotto(lottoNumbers);
        winningLotto = new WinningLotto(new Lotto(lottoNumbers), LottoNumber.of(7));
    }

    @Test
    public void 보너스번호_당첨번호포함() {
        assertThatThrownBy(() -> {
            new WinningLotto(new Lotto(lottoNumbers), LottoNumber.of(1));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void match() {
        assertThat(winningLotto.match(lotto)).isEqualTo(6);
    }

    @Test
    public void matchBonus() {
        assertThat(winningLotto.matchBonus(lotto)).isEqualTo(false);
    }
}
