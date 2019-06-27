package edu.nextstep.step3.domain;

import edu.nextstep.step3.Rank;

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
public class Lotto {

    private List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = new ArrayList<>(lotto);
    }

    public Map<LottoNumber, Rank> getLotteryLottoNumberResultCount(LottoNumber lottery) {
        Map<LottoNumber, Rank> lottoResultinfo = new HashMap<>();
        lotto.stream()
                .forEach(lottoNumber ->
                        lottoResultinfo.put(lottoNumber, Rank.matchCheck(lottoNumber.compareMatchNumberCount(lottery)))
                );
        return lottoResultinfo;
    }

    public Map<LottoNumber, Rank> addBonusNumberMatchLotto(Map<LottoNumber, Rank> lotteryInfo, Number bonusNumber) {
        Map<LottoNumber, Rank> cloneInfoMap = new HashMap<>(lotteryInfo);

        cloneInfoMap.keySet().stream()
                .filter(lotto -> cloneInfoMap.get(lotto).getMatch() == Rank.FIVE.getMatch())
                .filter(lotto -> lotto.contains(bonusNumber.getNumber()))
                .forEach(lotto ->
                        cloneInfoMap.put(lotto, Rank.BONUS)
                );
        return cloneInfoMap;
    }

    public int fetchIncome(Map<LottoNumber, Rank> lotteryInfo) {
        return lotteryInfo.keySet().stream()
                .mapToInt(lotto -> lotteryInfo.get(lotto).getLotteryMoney())
                .sum();
    }

    public List<LottoNumber> getExtractOfLotto() {
        return Collections.unmodifiableList(lotto);
    }
}