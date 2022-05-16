package lotto.domain;

import lotto.domain.constant.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(PurchaseLottoCount purchaseLottoCount) {
        this(purchaseLottoCount.getAmount());
    }

    public Lottos(int purchaseLottoCount) {
        createAutoLottos(purchaseLottoCount);
    }

    private void createAutoLottos(int purchaseLottoCount) {
        for (int i = 0; i < purchaseLottoCount; i++) {
            lottos.add(new Lotto(LottoFactory.createAutoLottoNumbers()));
        }
    }

    public int getLottoAmount() {
        return this.lottos.size();
    }

    public void confirmAll(LottoNumbers winningLottoNumbers) {
        for (Lotto lotto : this.lottos) {
            lotto.confirm(winningLottoNumbers);
        }
    }

    public int countMatchRank(Rank rank) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.isSameRank(rank))
                .count();
    }

    public List<LottoNumbers> getLottoNumbers() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoNumbers.add(lotto.getLottoNumbers());
        }
        return lottoNumbers;
    }

    public int getTotalPrizeMoney() {
        return lottos.stream().mapToInt(Lotto::getPrizeMoney).sum();
    }


    @Override
    public String toString() {
        return lottos.stream().map(lotto -> lotto.toString() + "\n").collect(Collectors.joining());
    }


}
