package lotto;

import lotto.lotto.AutoLottoStrategy;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoStrategyTest {

    @Test
    void 로또_번호_6개만_남긴다() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        AutoLottoStrategy autoLottoStrategy = new AutoLottoStrategy();
        autoLottoStrategy.addLottos(lottoNumbers);
        List<LottoNumber> newLottoNumbers = autoLottoStrategy.answerLotto(lottoNumbers);

        assertThat(newLottoNumbers).hasSize(6).allMatch(lotto -> lotto.getNumber() >= 1 && lotto.getNumber() <= 45);
    }

    @Test
    void 로또를_생성한다() {
        AutoLottoStrategy autoLottoStrategy = new AutoLottoStrategy();
        Lotto lotto = autoLottoStrategy.generateLotto();

        assertThat(lotto.getLotto()).hasSize(6).allMatch(lottoNumber -> lottoNumber.getNumber() >= 1 && lottoNumber.getNumber() <= 45);
    }

}
