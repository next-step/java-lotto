package edu.nextstep.step4.domain;

import edu.nextstep.step4.enums.Rank;

import java.util.*;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-25 00:02
 */
public class Lottos {

    private List<Lotto> lotto;

    public Lottos(List<Lotto> lotto) {
        this.lotto = new ArrayList<>(lotto);
    }

    public WinInfo getLotteryLottoNumberResultCount(WinLotto winLotto) {
        Map<Lotto, Rank> lottoResultInfo = new HashMap<>();
        lotto.stream()
                .forEach(lotto ->
                        lottoResultInfo.put(lotto, Rank.matchCheck(winLotto.compareMatchNumberCount(lotto))));
        return new WinInfo(lottoResultInfo);
    }

    public WinInfo addBonusNumberMatchLotto(WinInfo lotteryInfo, WinLotto winLotto) {
        Map<Lotto, Rank> matchWinInfo = new HashMap<>(lotteryInfo.getWinInfo());
        lotteryInfo.keySet()
                .filter(lotto -> lotteryInfo.isRank(lotto, Rank.FIVE))
                .filter(lotto -> lotto.contains(winLotto.getBonusNumber()))
                .forEach(lotto -> matchWinInfo.put(lotto, Rank.BONUS));
        return new WinInfo(matchWinInfo);
    }

    public int fetchIncome(WinInfo lotteryInfo) {
        return lotteryInfo.keySet()
                .mapToInt(lotto -> lotteryInfo.getRank(lotto).getLotteryMoney())
                .sum();
    }

    public List<Lotto> getExtractOfLotto() {
        return Collections.unmodifiableList(lotto);
    }
}