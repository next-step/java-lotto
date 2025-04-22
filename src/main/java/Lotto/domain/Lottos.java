package Lotto.domain;

import java.util.*;

import static Lotto.domain.Lotto.generateLottoNumbers;

public class Lottos {
    private static List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Lottos(int purchasedQty) {
        this.lottos = generate(purchasedQty).getLottos();
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

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
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

    public static Lottos generate(List<List<LottoNumber>> manualNumbers) {
        return generate(manualNumbers, 0);
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
