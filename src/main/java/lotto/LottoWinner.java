package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoWinner {
    public static final List<Integer> DEFAULT_WINNER_NUMBERLIST = List.of(0, 0, 0, 0);
    LottoWinnerNumber lottoWinnerNumber;
    LottoNumberMatchCount lottoNumberMatchCountList;

    public LottoWinner(String lottoWinnerNumbers) {
        this(stringToArrayList(lottoWinnerNumbers), new ArrayList<>(DEFAULT_WINNER_NUMBERLIST));
    }

    private static List<Integer> stringToArrayList(String lottoWinnerNumbers) {
        return Stream.of(lottoWinnerNumbers.replaceAll("\\s","").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public LottoWinner(List<Integer> lottoWinnerNumberList) {
        this(lottoWinnerNumberList, new ArrayList<>(DEFAULT_WINNER_NUMBERLIST));
    }

    public LottoWinner(List<Integer> lottoWinnerNumberList, List<Integer> lottoNumberMatchCountList) {
        this.lottoWinnerNumber = new LottoWinnerNumber(lottoWinnerNumberList);
        this.lottoNumberMatchCountList = new LottoNumberMatchCount(lottoNumberMatchCountList);
    }

    public int findMachingCount(List<Integer> lottoNumberList) {
        return lottoNumberList.stream()
                .filter(lottoWinnerNumber::contains)
                .mapToInt(e -> 1)
                .sum();
    }

    public void updateMatchingCount(int matchingCount) {
        if (matchingCount >= 3) {
            int matchingCountIndex = LottoMatchingCountDecision.convertMatchingNumberToIndex(matchingCount);
            lottoNumberMatchCountList.updateMatchingCount(matchingCountIndex);
        }
    }

    public void printMatchingCount() {
        lottoNumberMatchCountList.printMatchingCount();
    }

    public int winningAmount() {
        return lottoNumberMatchCountList.winningAmount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinner that = (LottoWinner) o;
        return Objects.equals(lottoWinnerNumber, that.lottoWinnerNumber) && Objects.equals(lottoNumberMatchCountList, that.lottoNumberMatchCountList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoWinnerNumber, lottoNumberMatchCountList);
    }
}
