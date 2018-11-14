package domain;

import domain.wrapper.Money;

import java.util.List;

public class LottoResultGroup {
    List<LottoResult> lottoResultGroup;

    public LottoResultGroup(List<LottoResult> lottoResultGroup) {
        this.lottoResultGroup = lottoResultGroup;
    }

    public int getSize() {
        return lottoResultGroup.size();
    }

//    public int getTotalReward() {
//        int sum = 0;
//        for (LottoResult winningLotto : lottoResultGroup) {
//            sum += winningLotto.getReward();
//        }
//        return sum;
//    }

    public Money getTotalReward() {
        int sum = 0;
        for (LottoResult winningLotto : lottoResultGroup) {
            sum += winningLotto.getReward();
        }
        return new Money(sum);
    }

    public int getCombineNumbers(LottoRank rank) {
        return (int) lottoResultGroup.stream()
                .filter(obj -> obj.getCombineLotto(rank.getCombineNum(), rank.equals(LottoRank.SECOND_PRICE))).count();
    }
}
