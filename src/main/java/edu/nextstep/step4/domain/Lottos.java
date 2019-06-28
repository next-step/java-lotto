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

    public Map<Lotto, Rank> getLotteryLottoNumberResultCount(Lotto lottery) {
        Map<Lotto, Rank> lottoResultinfo = new HashMap<>();
        lotto.stream()
                .forEach(lottoNumber ->
                        lottoResultinfo.put(lottoNumber, Rank.matchCheck(lottoNumber.compareMatchNumberCount(lottery)))
                );
        return lottoResultinfo;
    }

    public Map<Lotto, Rank> addBonusNumberMatchLotto(Map<Lotto, Rank> lotteryInfo, Number bonusNumber) {
        Map<Lotto, Rank> cloneInfoMap = new HashMap<>(lotteryInfo);

        cloneInfoMap.keySet().stream()
                .filter(lotto -> cloneInfoMap.get(lotto).getMatch() == Rank.FIVE.getMatch())
                .filter(lotto -> lotto.contains(bonusNumber.getNumber()))
                .forEach(lotto ->
                        cloneInfoMap.put(lotto, Rank.BONUS)
                );
        return cloneInfoMap;
    }

    public int fetchIncome(Map<Lotto, Rank> lotteryInfo) {
        return lotteryInfo.keySet().stream()
                .mapToInt(lotto -> lotteryInfo.get(lotto).getLotteryMoney())
                .sum();
    }

    public List<Lotto> getExtractOfLotto() {
        return Collections.unmodifiableList(lotto);
    }
}