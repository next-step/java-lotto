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

    public int count() {
        return lottoList.size();
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(this.lottoList);
    }

    public void matchingWinningNumbersAndBonusNumber(LottoNumbers winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottoList) {
            lotto.matching(winningNumbers, bonusNumber);
        }
    }

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
                .mapToDouble(lotto -> lotto.matchingInfo().getPayout())
                .sum() / (lottoList.size() * LOTTO_PRICE);
    }


}
