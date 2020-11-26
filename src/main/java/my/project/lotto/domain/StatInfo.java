package my.project.lotto.domain;

import my.project.utils.CollectionUtils;

import java.util.List;

public class StatInfo {
    private final List<Lotto> records;
    private final List<Integer> winningNumbers;

    public StatInfo(List<Lotto> records, List<Integer> winningNumbers) {
        CollectionUtils.isListQualified(records);
        CollectionUtils.isListQualified(winningNumbers);

        this.records = records;
        this.winningNumbers = winningNumbers;
    }

    public List<Lotto> getRecords() {
        return this.records;
    }

    public List<Integer> getWinningNumber() {
        return this.winningNumbers;
    }

    public int getMoney() {
        return records.size() * Chance.PRICE;
    }

}
