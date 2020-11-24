package my.project.lotto.domain;

import my.project.utils.CollectionUtils;

import java.util.List;

public class StatInfo {
    private final List<GameRecord> records;
    private final List<Integer> winningNumbers;

    public StatInfo(List<GameRecord> records, List<Integer> winningNumbers) {
        CollectionUtils.isListQualified(records);
        CollectionUtils.isListQualified(winningNumbers);

        this.records = records;
        this.winningNumbers = winningNumbers;
    }

    public List<GameRecord> getRecords() {
        return this.records;
    }

    public List<Integer> getWinningNumber() {
        return this.winningNumbers;
    }

}
