package lotto.oop.domain;

import java.util.*;

public class LottoIssue {
    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 6;
    private int amount;
    private List<LottoNumber> resultList;
    private IssueStats issueStats;


    public LottoIssue(int amount) {
        this.amount = amount;
    }

    public List<LottoNumber> publishLottoList(int count) {
        resultList = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            LottoNumber lotto = new LottoNumber();
            lotto.generateNumbers();
            resultList.add(lotto);
        }
        return resultList;
    }

    public void checkNumber(List<Integer> winNumbers, int bonusNumber) {
        for(int i = 0; i < winNumbers.size(); i++) {
            vefiryCheckNumber(winNumbers, i);
        }
        issueStats = new IssueStats(amount);
        for (LottoNumber issuelotto: resultList) {
            issueStats.setIssueStats(issuelotto, winNumbers, bonusNumber);
        }
    }

    private void vefiryCheckNumber(List<Integer> winNumbers, int i) {
        if (winNumbers.get(i) >= 46 || winNumbers.get(i) <= 0) {
            throw new IllegalArgumentException("당첨 볼은 1에서 45값만 유효합니다.");
        }
    }

    public List<LottoNumber> getResultList() {
        return resultList;
    }

    public IssueStats getIssueStats() {
        return issueStats;
    }
}