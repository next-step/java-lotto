package step02.model.lotto;

import step02.dto.LottosDTO;
import step02.model.numberRule.NumberRule;
import step02.model.rank.Rank;
import step02.model.rank.Ranks;

import java.util.ArrayList;
import java.util.List;

import static step02.utils.LottoConfig.*;

public class Lottos {
    private List<LottoNumbers> lottos = new ArrayList<>();
    private LottoCount lottoCount;

    public Lottos(int count) {
        lottoCount = new LottoCount(count);
    }

    public void makeLotto(NumberRule numberRule) {
        for (int i = ZERO; i < lottoCount.getCount(); i++) {
            lottos.add(new LottoNumbers(numberRule));
        }
    }

    public Ranks compareMatchNumber(LottoNumbers winnerNumbers, LottoNumber bonusNumber) {
        Ranks ranks = new Ranks();
        lottos.forEach(numbers -> {
            int matchCount = numbers.countCompareMatchNumber(winnerNumbers);
            boolean matchBonus = numbers.compareMatchBonusNumber(bonusNumber);
            ranks.addRanks(Rank.getMatchRank(matchCount, matchBonus));
        });
        return ranks;
    }

    public LottosDTO getLottoResult() {
        LottosDTO lottosDTO = new LottosDTO();
        lottosDTO.setLottos(lottos);
        lottosDTO.setLottoCount(lottoCount);
        return lottosDTO;
    }

}
