package lotto.view;

import lotto.domain.LottoStore;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Numbers;
import lotto.domain.lotto.WinningLotto;
import lotto.utils.TestLottoGenerator;
import lotto.view.vo.MatchResult;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    public void 열개_모두_5등일경우_수익률_5배() {
        int money = 10000;
        int manualCount = 3;
        List<Numbers> manualLottoNumbers = new ArrayList<>();
        Numbers numbers = new Numbers(Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        ));
        manualLottoNumbers.add(numbers);
        manualLottoNumbers.add(numbers);
        manualLottoNumbers.add(numbers);

        LottoStore lottoStore = new LottoStore(new TestLottoGenerator(), money, manualLottoNumbers);

        Numbers winningLottoNumbers = new Numbers(Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(8),
            new LottoNumber(9),
            new LottoNumber(10)
        ));

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, new LottoNumber(20));
        MatchResult matchResult = new MatchResult(winningLotto);

        matchResult.calculate(lottoStore.getLottos());

        LottoResult lottoResult = new LottoResult(winningLotto);
        lottoResult.generate(lottoStore.getLottos());

        assertThat(lottoResult.getRewardPercent(money)).isEqualTo("5.00");
    }
}
