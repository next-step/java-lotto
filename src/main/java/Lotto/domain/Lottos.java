package Lotto.domain;

import java.util.*;

public class Lottos {
    private static List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public ResultStats getSummary(Set<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        LottoResultCalculator calculator = new LottoResultCalculator(lottos, winningNumbers, bonusNumber);
        Map<Rank, Integer> stats = calculator.calculateStats();
        int totalPrize = calculator.calculateTotalPrize();

        return new ResultStats(stats, totalPrize);
    }

    public static Lottos generate(int autoCount) {
        return generate(List.of(), autoCount);
    }

    public static Lottos generate(List<List<LottoNumber>> manualNumbers, int autoCount) {
        Lottos allTickets = new Lottos();

        for (List<LottoNumber> numbers : manualNumbers) {
            allTickets.add(LottoGenerator.manual(numbers));
        }

        for (int i = 0; i < autoCount; i++) {
            allTickets.add(LottoGenerator.auto());
        }

        return allTickets;
    }
}
