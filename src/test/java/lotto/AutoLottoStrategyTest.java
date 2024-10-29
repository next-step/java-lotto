package lotto;

import lotto.lotto.AutoLottoStrategy;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;
import lotto.lotto.LottoParameters;
import lotto.lotto.Lottos;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoStrategyTest {

    @Test
    void 자동_로또_생성시_로또번호_6개만_생성되고_번호유효성_체크() {
        LottoParameters lottoParameters = new LottoParameters(1);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        AutoLottoStrategy autoLottoStrategy = new AutoLottoStrategy();
        autoLottoStrategy.addLottos(lottoNumbers);
        SortedSet<LottoNumber> newLottoNumbers = autoLottoStrategy.answerLotto(lottoNumbers);

        assertThat(newLottoNumbers).hasSize(6).allMatch(lotto -> lotto.getNumber() >= 1 && lotto.getNumber() <= 45);
    }

    @Test
    void 자동_로또를_3개_생성하고_번호유효성체크() {
        LottoParameters lottoParameters = new LottoParameters(3);
        AutoLottoStrategy autoLottoStrategy = new AutoLottoStrategy();
        Lottos lottos = autoLottoStrategy.generateLotto(lottoParameters);

        assertThat(lottos.getLottos()).hasSize(3);

        for(Lotto lotto : lottos.getLottos()){
            assertThat(lotto.getLotto()).hasSize(6).allMatch(lottoNumber -> lottoNumber.getNumber() >= 1 && lottoNumber.getNumber() <= 45);
        }
    }

}
