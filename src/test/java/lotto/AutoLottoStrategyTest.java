package lotto;

import lotto.lotto.AutoLottoStrategy;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;
import lotto.lotto.Lottos;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoStrategyTest {

    @Test
    void 자동_로또_생성시_로또번호_6개만_생성되고_번호유효성_체크() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        AutoLottoStrategy autoLottoStrategy = new AutoLottoStrategy(1);
        autoLottoStrategy.addLottos(lottoNumbers);
        List<LottoNumber> newLottoNumbers = autoLottoStrategy.answerLotto(lottoNumbers);

        assertThat(newLottoNumbers).hasSize(6).allMatch(lotto -> lotto.getNumber() >= 1 && lotto.getNumber() <= 45);
    }

    @Test
    void 자동_로또를_3개_생성하고_번호유효성체크() {
        AutoLottoStrategy autoLottoStrategy = new AutoLottoStrategy(3);
        Lottos lottos = autoLottoStrategy.generateLotto();

        assertThat(lottos.getLottos()).hasSize(3);

        for(Lotto lotto : lottos.getLottos()){
            assertThat(lotto.getLotto()).hasSize(6).allMatch(lottoNumber -> lottoNumber.getNumber() >= 1 && lottoNumber.getNumber() <= 45);
        }
    }

}
