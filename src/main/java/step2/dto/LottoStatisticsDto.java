package step2.dto;

import step2.domain.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class LottoStatisticsDto {

    private final List<Integer> rankList;
    private final List<Integer> winningMoney;
    private final List<Integer> countOfRank;
    private final String ratioOfReturn;

    public LottoStatisticsDto(Map<Integer, List<Rank>> ranks, String statistics) {
        this.rankList = createRanList();
        this.winningMoney = createWinningMoneyList(ranks);
        this.countOfRank = createCountOfRank(ranks);
        this.ratioOfReturn = statistics;
    }

    private List<Integer> createRanList() {
        return Arrays.stream(Rank.values())
                .map(Rank::getCountOfMatch)
                .filter(money -> money != 0)
                .sorted()
                .collect(toList());
    }

    private List<Integer> createWinningMoneyList(Map<Integer, List<Rank>> ranks) {
        return ranks.keySet().stream()
                .filter(rank -> rank != 0)
                .sorted()
                .collect(toList());
    }

    private List<Integer> createCountOfRank(Map<Integer, List<Rank>> ranks) {
        return winningMoney.stream()
                .map(ranks::get)
                .map(List::size)
                .collect(toList());
    }

    public List<Integer> getRankList() {
        return rankList;
    }

    public List<Integer> getWinningMoney() {
        return winningMoney;
    }

    public List<Integer> getCountOfRank() {
        return countOfRank;
    }

    public String getRatioOfReturn() {
        return ratioOfReturn;
    }
}
