package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoWinner {
    public static final int DEFAULT_WINNING_COUNT = 0;

    private OneTimeRoundLottoNumberList winnerLottoNumberList;

    private WinningLottoCount winningLottoCountMap;

    public LottoWinner(String lottoWinnerNumbers) {
        this(stringToArrayList(lottoWinnerNumbers), initWinnigLottoCountMap());
    }

    public LottoWinner(List<Integer> lottoWinnerNumberList) {
        this(lottoWinnerNumberList, initWinnigLottoCountMap());
    }

    public LottoWinner(List<Integer> lottoWinnerNumberList,  Map<Integer, Integer> winningLottoCountMap) {
        this.winnerLottoNumberList = new OneTimeRoundLottoNumberList(lottoWinnerNumberList);
        this.winningLottoCountMap = new WinningLottoCount(winningLottoCountMap);
    }

    public int diffLottoAndWinningLotto(List<Integer> lottoNumberList) {
        return lottoNumberList.stream()
                .filter(winnerLottoNumberList::compareNumber)
                .mapToInt(e -> 1)
                .sum();
    }

    public void recordWinningCount(int matchingCount) {
        if (matchingCount >= 3) {
            int winningRank = LottoWinningCountDecision.convertMatchingNumberToRank(matchingCount);
            winningLottoCountMap.recordWinningCount(winningRank);
        }
    }

    public void printWinningCount() {
        winningLottoCountMap.printWinningCount();
    }

    public int winningAmount() {
        return winningLottoCountMap.winningAmount();
    }

    private static Map<Integer, Integer> initWinnigLottoCountMap() {
        Map<Integer, Integer> winningLottoCountMap = new TreeMap<>(Comparator.reverseOrder());
        Arrays.asList(1,2,3,4).forEach(i -> winningLottoCountMap.put(i, DEFAULT_WINNING_COUNT));
        return winningLottoCountMap;
    }

    private static List<Integer> stringToArrayList(String lottoWinnerNumbers) {
        return Stream.of(lottoWinnerNumbers.replaceAll("\\s","").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinner that = (LottoWinner) o;
        return Objects.equals(winnerLottoNumberList, that.winnerLottoNumberList) && Objects.equals(winningLottoCountMap, that.winningLottoCountMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerLottoNumberList, winningLottoCountMap);
    }
}
