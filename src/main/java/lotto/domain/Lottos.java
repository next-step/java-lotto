package lotto.domain;

import lotto.constant.Rank;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createAutoLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(LottoNumbers.createRandomLottoNumbers()));
        }
        return new Lottos(lottos);
    }

    public int count() {
        return lottos.size();
    }

    public void confirmAll(LottoNumbers winningNumbers) {
        for (Lotto lotto : lottos) {
            lotto.confirm(winningNumbers);
        }
    }
    public void confirmAll(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        for (Lotto lotto : lottos) {
            lotto.confirm(winningNumbers, bonusNumber);
        }
    }

    public List<Lotto> toList() {
        return lottos;
    }

    public int countMatchResult(Rank rank) {
        return (int) lottos.stream()
                .map(Lotto::findMatchResult)
                .filter(mr -> mr == rank)
                .count();
    }

    public int calculateTotalWinPrice() {
        return lottos.stream()
                .map(Lotto::findMatchResult)
                .mapToInt(Rank::winPrice)
                .sum();
    }
}
