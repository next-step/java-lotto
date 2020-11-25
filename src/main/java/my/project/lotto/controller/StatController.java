package my.project.lotto.controller;

import my.project.lotto.domain.GameRecord;
import my.project.lotto.domain.StatRecord;
import my.project.lotto.domain.StatInfo;
import my.project.lotto.domain.Statistics;
import my.project.utils.CollectionUtils;
import my.project.utils.StringUtils;

import java.util.List;

public class StatController {
    private final StatInfo info;
    private final Statistics stat;

    public StatController(List<GameRecord> records, String winningNumber) {
        CollectionUtils.isListQualified(records);
        StringUtils.isQualified(winningNumber);

        List<Integer> winningNumbers = StringUtils.parseToIntList(winningNumber);

        this.info = new StatInfo(records, winningNumbers);
        this.stat = new Statistics();
    }

    public StatRecord stat() {
        return stat.analyze(info);
    }

}
