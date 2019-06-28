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

    public WinInfo getLotteryLottoNumberResultCount(Lotto lottery) {
        Map<Lotto, Rank> lottoResultinfo = new HashMap<>();
        lotto.stream()
                .forEach(lottoNumber ->
                        lottoResultinfo.put(lottoNumber, Rank.matchCheck(lottoNumber.compareMatchNumberCount(lottery))));
        return new WinInfo(lottoResultinfo);
    }

    public WinInfo addBonusNumberMatchLotto(WinInfo lotteryInfo, Number bonusNumber) {
        Map<Lotto, Rank> matchWinInf = new HashMap<>(lotteryInfo.getWinInfo());
        lotteryInfo.keySet()
                .filter(lotto -> lotteryInfo.get(lotto).getMatch() == Rank.FIVE.getMatch())
                .filter(lotto -> lotto.contains(bonusNumber))
                .forEach(lotto -> matchWinInf.put(lotto, Rank.BONUS));
        return new WinInfo(matchWinInf);
    }

//    public WinInfo addBonusNumberMatchLotto(WinInfo lotteryInfo, WinLotto winLotto) {
//        Map<Lotto, Rank> matchWinInf = new HashMap<>(lotteryInfo.getWinInfo());
//        lotteryInfo.keySet()
//                .filter(lotto -> lotteryInfo.get(lotto).getMatch() == Rank.FIVE.getMatch())
//                .filter(lotto -> lotto.contains(winLotto))
//                .forEach(lotto -> matchWinInf.put(lotto, Rank.BONUS));
//        return new WinInfo(matchWinInf);
//    }

    public int fetchIncome(WinInfo lotteryInfo) {
        return lotteryInfo.keySet()
                .mapToInt(lotto -> lotteryInfo.get(lotto).getLotteryMoney())
                .sum();
    }

    public List<Lotto> getExtractOfLotto() {
        return Collections.unmodifiableList(lotto);
    }
}