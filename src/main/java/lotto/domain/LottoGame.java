package lotto.domain;

import java.util.ArrayList;
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

    public List<Lotto> getAllLottoNumbersForPrint() {
        return this.lottos;
    }

    public WinningStatistics getStatistics(LotteryNumbers lotteryNumbers) {
        return new WinningStatistics(lotteryNumbers, lottos);
    }

    public String getBuyCountForPrint() {
        return issueRequest.getBuyCountForPrint();
    }
}
