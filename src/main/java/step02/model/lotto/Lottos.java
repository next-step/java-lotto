package step02.model.lotto;

import step02.dto.LottosDTO;
import step02.model.numberRule.InputNumberRule;
import step02.model.numberRule.NumberRule;
import step02.model.numberRule.RandomNumberRule;
import step02.model.rank.Rank;
import step02.model.rank.Ranks;
import step02.ui.InputView;

import java.util.ArrayList;
import java.util.List;

import static step02.utils.LottoConfig.*;

public class Lottos {
    private List<LottoNumbers> lottos = new ArrayList<>();
    private LottoCount lottoCount;


    public Lottos(int lottoCount) {
        this.lottoCount = new LottoCount(lottoCount);
    }

    public void setLottoCount() {
        lottoCount.setLottoManualCount(InputView.inputManualLottoCount());
        lottoCount.setLottoAutomaticCount();
    }

    public void makeLotto(NumberRule numberRule) {
        lottos.add(new LottoNumbers(numberRule));
    }

    public void makeManualLotto() {
        for (int i = 0; i < lottoCount.getManualCount(); i++) {
            makeLotto(new InputNumberRule(InputView.inputManualLotto(lottoCount.getManualCount())));
        }
    }

    public void makeAutomaticLotto() {
        for (int i = 0; i < lottoCount.getAutomaticCount(); i++) {
            makeLotto(new RandomNumberRule());
        }
    }

    public Ranks compareMatchNumber(LottoNumbers winnerNumbers, LottoNumber bonusNumber) {
        Ranks ranks = new Ranks();

        for (LottoNumbers numbers : lottos) {
            if (numbers.duplicateNumber(bonusNumber)) {
                throw new IllegalArgumentException(ERROR_INPUT_WINNER_NUMBER);
            }

            int matchCount = numbers.countCompareMatchNumber(winnerNumbers);
            boolean matchBonus = numbers.compareMatchBonusNumber(bonusNumber);
            ranks.addRanks(Rank.getMatchRank(matchCount, matchBonus));
        }

        return ranks;
    }

    public LottosDTO getLottoResult() {
        return new LottosDTO(lottos, lottoCount);
    }

}
