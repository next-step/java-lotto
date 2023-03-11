package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoGame {
    public static final Money LOTTO_PRICE = new Money(1000);


    private final List<Lotto> lottos;
    private final IssueRequest issueRequest;

    public LottoGame(Money lottoPay) {
        this.issueRequest = new IssueRequest(lottoPay.division(LOTTO_PRICE).toInteger());
        this.lottos = new ArrayList<>();
        issueRequest.issue(lottos);

    }

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
        this.issueRequest = new IssueRequest(lottos.size());
    }

    public Money getBuyPrice() {
        return issueRequest.getPrice();
    }

    public String getAllLottoNumbersForPrint() {
        StringBuilder allLottoNumbers = new StringBuilder();
        lottos.forEach(lotto -> allLottoNumbers.append(lotto.getLottoNumbersForPrint()).append("\n"));
        return allLottoNumbers.toString();
    }

    public WinningStatistics getStatistics(LotteryNumbers lotteryNumbers) {
        WinningStatistics winningStatistics = new WinningStatistics();
        lottos.stream()
                .map(lotto -> {
                    HashSet<Integer> lottoNumbers = new HashSet<>(lotto.getLottoNumbers());
                    return lotteryNumbers.getWinningGrade(lottoNumbers);
                })
                .forEach(winningStatistics::add);

        return winningStatistics;
    }

    public String getBuyCountForPrint() {
        return issueRequest.getBuyCountForPrint();
    }
}
