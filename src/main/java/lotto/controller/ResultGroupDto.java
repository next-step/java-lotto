package lotto.controller;

import lotto.domain.ResultGroup;
import lotto.domain.WinningResult;

public class ResultGroupDto {

    private ResultGroup resultGroup;

    public ResultGroupDto(ResultGroup resultGroup) {
        this.resultGroup = resultGroup;
    }

    public int howManyHave(WinningResult result) {
        return resultGroup.howManyHave(result);
    }
}
