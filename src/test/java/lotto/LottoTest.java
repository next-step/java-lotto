package lotto;

import lotto.domain.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 구입_금액에_따라_로또_발급개수가_결정되는지() {
        final int won = 14000;

        LottoList lottoList = LottoMachine.purchase(won);

        assertThat(lottoList.size()).isEqualTo(14);
    }

    @Test
    public void 로또의_각_번호는_유일한지() {
        final Lotto lotto = new Lotto();

        Set<LottoNumber> lottoNumbers = new HashSet<>(lotto.getLottoNumbers());

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    public void 발급개수만큼_생성된_각_로또번호가_유일한지() {
        final LottoList lottos = LottoMachine.purchase(14000);

        for (Lotto lotto : lottos.getLottos()) {
            Set<LottoNumber> lottoNumbers = new HashSet<>(lotto.getLottoNumbers());
            assertThat(lottoNumbers.size()).isEqualTo(6);
        }
    }
}
