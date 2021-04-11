package step02;

import java.util.ArrayList;
import java.util.List;

import static step02.LottoConfig.*;

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

    public Ranks compareMatchNumber(LottoNumbers winnerNumbers) {
        Ranks ranks = new Ranks();
        lottos.forEach(numbers -> {
            int matchCount = numbers.countCompareMatchNumber(winnerNumbers);
            ranks.addRanks(Rank.getMatchRank(matchCount));
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
