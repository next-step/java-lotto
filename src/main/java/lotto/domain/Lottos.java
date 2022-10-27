package lotto.domain;

import lotto.common.type.WinnerRank;
import lotto.common.type.WinnerRankCondition;
import lotto.input.ManualLottoInput;
import lotto.input.LottoTicket;
import lotto.strategy.LottoRandomGenerateStrategy;
import lotto.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public Lottos(int lottoSize) {
        while (lottos.size() < lottoSize) {
            lottos.add(new Lotto(new LottoRandomGenerateStrategy()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottosAmount(){
        return lottos.size();
    }

    public static final int SECOND_PLACE_CORRECT_COUNT = 5;

    public RewardStatistics countWinningNumbers(WinningLotto winningLotto) {
        RewardStatistics rewardStatistics = new RewardStatistics();
        lottos.forEach(lotto -> {
            int sameSize = lotto.getSameElementsSize(winningLotto.getWinningLotto());
            boolean correctBonus = lotto.hasSameElement(winningLotto.getBonusWinningNumber());
            boolean needBonus = sameSize == SECOND_PLACE_CORRECT_COUNT;
            rewardStatistics.plusCount(WinnerRank.valueOf(new WinnerRankCondition(sameSize, needBonus && correctBonus)));
        });
        return rewardStatistics;
    }

    public static Lottos of(LottoTicket lottoTicket, ManualLottoInput manualLottoInput){
        if(lottoTicket.getTicketAmt() < manualLottoInput.getInputSize()) {
            throw new IllegalArgumentException("manual input count cannot be bigger than total lotto count");
        }
        List<Lotto> result = new ArrayList<>();
        for (String lottoInput : manualLottoInput.getManualLottoInput()){
            result.add(new Lotto(StringUtils.refineNumbers(lottoInput)));
        }
        for (int i = 0; i < lottoTicket.getRandomTicketAmt(manualLottoInput.getInputSize()); i++) {
            result.add(new Lotto(new LottoRandomGenerateStrategy()));
        }
        return new Lottos(result);
    }
}
