package step2step3.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private final int lottoPrice;

    public LottoTickets(List<LottoTicket> lottoTickets, int lottoPrice) {
        this.lottoTickets = lottoTickets;
        this.lottoPrice = lottoPrice;
    }

    public int numberOfTickets() {
        return lottoTickets.size();
    }

    public void printNumbers(OutputDevice outputDevice) {
        lottoTickets.forEach(lottoTicket -> lottoTicket.printNumbers(outputDevice));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }

    public YieldCalculator yieldCalculator(RankJudgmentInformation rankJudgmentInformation) {
        return new YieldCalculator(lottoPrice, ranks(rankJudgmentInformation));
    }

    private List<Rank> ranks(RankJudgmentInformation rankJudgmentInformation) {
        List<Rank> ranks = new ArrayList<>();
        ranks.addAll(ranksExcludingSecond(rankJudgmentInformation.winningLottoTicket()));
        ranks.addAll(secondRanks(rankJudgmentInformation));
        return ranks;
    }

    private List<Rank> ranksExcludingSecond(LottoTicket winningLottoTicket) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.rank(winningLottoTicket))
                .collect(Collectors.toUnmodifiableList());
    }

    private List<Rank> secondRanks(RankJudgmentInformation rankJudgmentInformation) {
        return lottoTickets.stream()
                .filter(rankJudgmentInformation::isSecond)
                .map(lottoTicket -> Rank.SECOND)
                .collect(Collectors.toList());
    }

    public MatchIndicatorCalculator matchIndicatorCalculator(RankJudgmentInformation rankJudgmentInformation) {
        return new MatchIndicatorCalculator(ranks(rankJudgmentInformation));
    }
}

