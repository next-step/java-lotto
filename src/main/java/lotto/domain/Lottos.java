package lotto.domain;

import lotto.constant.MatchResult;

import java.util.List;
import java.util.Optional;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    public void confirmAll(WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos) {
            lotto.confirm(winningNumbers);
        }
    }

    public List<Lotto> toList() {
        return lottos;
    }

    public int countMatchResult(MatchResult matchResult) {
        return (int) lottos.stream()
                .map(Lotto::findMatchResult)
                .filter(mr -> mr == matchResult)
                .count();
    }

    public int calculateTotalWinPrice() {
        return lottos.stream()
                .map(Lotto::findMatchResult)
                .mapToInt(MatchResult::winPrice)
                .sum();
    }
}
