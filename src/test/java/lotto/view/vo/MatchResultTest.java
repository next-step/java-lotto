package lotto.view.vo;

import lotto.domain.LottoStore;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Numbers;
import lotto.domain.lotto.WinningLotto;
import lotto.enums.Rank;
import lotto.utils.ManualLottoGenerator;
import lotto.utils.TestRandomLottoGenerator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MatchResultTest {

    @Test
    public void 로또_매칭_결과_저장_테스트() {
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

        LottoStore lottoStore = new LottoStore(new ManualLottoGenerator(), new TestRandomLottoGenerator(), money, manualLottoNumbers);

        Numbers winningLottoNumbers = new Numbers(Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(7)
        ));

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, new LottoNumber(6));
        MatchResult matchResult = new MatchResult(winningLotto);

        matchResult.calculate(lottoStore.getLottos());

        assertThat(matchResult.getRanks().get(Rank.SECOND)).isEqualTo(10);
    }

    @Test
    public void 매칭_결과를_바탕으로_수익률_계산() {
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

        LottoStore lottoStore = new LottoStore(new ManualLottoGenerator(), new TestRandomLottoGenerator(), money, manualLottoNumbers);

        Numbers winningLottoNumbers = new Numbers(Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(7)
        ));

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, new LottoNumber(6));
        MatchResult matchResult = new MatchResult(winningLotto);

        matchResult.calculate(lottoStore.getLottos());

        assertThat(matchResult.calculateTotalReward()).isEqualTo(300_000_000L);
    }
}
