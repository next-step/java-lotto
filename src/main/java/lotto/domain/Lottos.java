package lotto.domain;

import lotto.domain.constant.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(PurchaseLottoCount purchaseLottoCount, List<LottoNumbers> manualLottoNumbers) {
        validate(purchaseLottoCount, manualLottoNumbers);
        addManualLottos(manualLottoNumbers);
        addAutoLottos(purchaseLottoCount.getAutoLottoCount());
    }

    private void validate(PurchaseLottoCount purchaseLottoCount, List<LottoNumbers> manualLottoNumbers) {
        if (purchaseLottoCount == null) {
            throw new IllegalArgumentException("구매 갯수가 존재하지 않습니다.");
        }

        if (manualLottoNumbers == null || manualLottoNumbers.isEmpty()) {
            throw new IllegalArgumentException("수동 번호가 존재하지 않습니다.");
        }
    }

    private void addAutoLottos(int purchaseLottoCount) {
        for (int i = 0; i < purchaseLottoCount; i++) {
            lottos.add(new Lotto(LottoFactory.createAutoLottoNumbers()));
        }
    }

    private void addManualLottos(List<LottoNumbers> manualLottoNumbers) {
        for (LottoNumbers lottoNumbers : manualLottoNumbers) {
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    public void confirmAll(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
        for (Lotto lotto : this.lottos) {
            lotto.confirm(winningLottoNumbers, bonusNumber);
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
