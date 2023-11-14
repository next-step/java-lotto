package lotto.model;

import java.util.List;

public class Lottery {
    private final List<Integer> winnerNumbers;
    private final List<Lotto> lottos;
    private long totalMoney;

    public Lottery(List<Integer> winnerNumbers, List<Lotto> lottos) {
        this.winnerNumbers = winnerNumbers;
        this.lottos = lottos;
    }
    public void depositMoney(long money){
        this.totalMoney += money;
    }

    public long money(){
        return this.totalMoney;
    }

    public int checkForWin(int correctCount) {
        return (int) lottos.stream()
                .filter(lotto -> winnerNumbers.stream()
                        .filter(number -> lotto.lottoNumbers().contains(number))
                        .count() == correctCount)
                .count();
    }

}
