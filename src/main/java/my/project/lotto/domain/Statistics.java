package my.project.lotto.domain;

import java.util.List;

public class Statistics {
    private final StatRecord statRecord;

    public Statistics() {
        this.statRecord = new StatRecord();
    }

    public StatRecord analyze(StatInfo info) {
        rank(info);
        profit(info);
        return this.statRecord;
    }

    private void rank(StatInfo info) {
       List<GameRecord> records = info.getRecords();
       for (GameRecord record : records) {
           setRank(hasWinNumber(record, info.getWinningNumber()));
       }
    }

    private int hasWinNumber(GameRecord record, List<Integer> winningNumber) {
        int myRecord = 0;
        for (int num : record.get()) {
            myRecord += count(winningNumber, num);
        }
        return myRecord;

    }

    private int count(List<Integer> winningNumber, int num) {
        int ret = 0;
        if (winningNumber.contains(num)) ret = 1;
        return ret;
    }

    private void setRank(int winNumber) {

    }

    private void profit(StatInfo info) {
    }

}
