package lotto.domains;

import lotto.enums.MatchingInfo;
import lotto.enums.PurchasingWay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final static int LOTTO_PRICE = 1000;

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = new ArrayList<>(lottoList);
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(this.lottoList);
    }

    public void matchingWinningNumbersAndBonusNumber(WinningLotto winningLotto) {
        for (Lotto lotto : lottoList) {
            lotto.matching(winningLotto);
        }
    }

    //TODO refactor: 비슷한역할을 하는 중복된 코드인데 중복제거를 할수 없을까?
    public int countOfMatchingNumber(MatchingInfo matchingInfo) {
        return (int) lottoList.stream()
                .filter(lotto -> lotto.matchingInfo() == matchingInfo)
                .count();
    }

    public int countOfPurchasingWay(PurchasingWay purchasingWay) {
        return (int) lottoList.stream()
                .filter(lotto -> lotto.purchasingWay() == purchasingWay)
                .count();
    }

    public double rateOfReturn() {
        return lottoList.stream()
                //TODO refactor: lotto.getPayout() 으로 할수 있지 않을까?
                .mapToDouble(lotto -> lotto.matchingInfo().getPayout())
                .sum() / (lottoList.size() * LOTTO_PRICE);
    }


}
