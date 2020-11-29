package my.project.lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created : 2020-11-25 오전 8:08
 * Developer : Seo
 */
public enum Win {
    FIRST(1, 6, 0),
    THIRD(3, 5, 0),
    FOURTH(4, 4, 0),
    FIFTH(5, 3, 0),
    EMPTY(0, 0, 0);

    private final int title;
    private final int num;
    private int count;

    Win(int title, int num, int count) {
        this.title = title;
        this.num = num;
        this.count = count;
    }

    public static Win findRank(GameRecord record, List<Integer> winningNumbers) {
        return Arrays.stream(Win.values())
                .filter(winner -> winner.num == hasWinNumber(record, winningNumbers))
                .findAny()
                .orElse(EMPTY);
    }

    private static int hasWinNumber(GameRecord record, List<Integer> winningNumbers) {
        List<Integer> list = winningNumbers.stream()
                .filter(winningNumber -> record.get().stream().anyMatch(winningNumber::equals))
                .collect(Collectors.toList());
        return list.size();
    }

    public int getTitle() {
        return this.title;
    }

    public void setCount() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }

}
