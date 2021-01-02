package lotto.oop.domain;

import java.util.*;

public class LottoIssue {
    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 6;
    private List<LottoNumber> resultList;
    private IssueStats issueStats;

    public List<LottoNumber> publishLottoList(int count, List<LottoNumber> handOperationLotto) {
        resultList = handOperationLotto;
        for(int i = 0; i < count; i++) {
            LottoNumber lotto = new LottoNumber();
            lotto.generateNumbers();
            resultList.add(lotto);
        }
        return resultList;
    }

    public void checkNumber(List<Integer> winNumbers, int bonusNumber) {
        issueStats = new IssueStats();
        for (LottoNumber issuelotto: resultList) {
            issueStats.setIssueStats(issuelotto, winNumbers, bonusNumber);
        }
    }

    public List<LottoNumber> getResultList() {
        return resultList;
    }

    public IssueStats getIssueStats() {
        return issueStats;
    }
}