package lotto.domain;

import java.util.List;

public class Scanner {

    private List<Integer> winningNumbers;

    public Scanner(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void scan(LottoTicket lottoTicket) {
        long matchingScore = lottoTicket.getNumbers().stream()
                        .filter(n -> winningNumbers.contains(n)).count();
        lottoTicket.saveMatchingScore(matchingScore);
    }
}
