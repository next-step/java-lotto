package lotto;

import java.util.List;

public class LottoGameService {
    LottoTickets lottoTickets;
    List<Integer> winningNumbers;
    int[] counter = new int[7];

    public LottoGameService(LottoTickets lottoTickets, List<Integer> winningNumbers) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
    }

    public static LottoGameService of(LottoTickets lottoTickets, List<Integer> winningNumbers) {
        return new LottoGameService(lottoTickets, winningNumbers);
    }

    public void countMatchingTickets() {
        counter = lottoTickets.counterOfMatchingTickets(winningNumbers);
    }

    public int getCountOfMatchingNumber(int number) {
        return counter[number];
    }

    public double returnRate() {
        double result = (double) sumOfPrize() / lottoTickets.totalPrice();
        return Math.floor(result * 100) / 100;
    }

    public long sumOfPrize() {
        long sumOfFirstPrize = 2000000000 * getCountOfMatchingNumber(6);
        long sumOfSecondPrize = 1500000 * getCountOfMatchingNumber(5);
        long sumOfThirdPrize = 50000 * getCountOfMatchingNumber(4);
        long sumOfFourthPrize = 5000 * getCountOfMatchingNumber(3);
        return sumOfFirstPrize + sumOfSecondPrize + sumOfThirdPrize + sumOfFourthPrize;
    }
}
