package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> lottoNumList;
    private int winningNumberCount;

    public Lotto(List<Integer> numList) {
        numList.forEach(Lotto::validateLottoNum);
        this.lottoNumList = numList.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public String toString() {

        return "[" + lottoNumList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }

    public void getOverlappingLottoNum(Lotto newLotto) {
        this.winningNumberCount = (int) this.lottoNumList.stream()
                .filter(newLotto.lottoNumList::contains)
                .count();

    }

    private static void validateLottoNum(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("Number should be in 1 to 45");
        }
    }

    public boolean isWinningNumberEqual(int winningCount) {
        return winningCount == this.winningNumberCount;
    }
}
