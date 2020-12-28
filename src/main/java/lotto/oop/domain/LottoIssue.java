package lotto.oop.domain;

import java.util.*;

public class LottoIssue {
    public static final int FROM_INDEX = 0;
    public static final int TO_INDEX = 6;
    private int count;

    private List<LottoNumber> resultList;
    private Map<Integer, Integer> issueStats;

    public LottoIssue(int count) {
        this.count = count;
    }

    public List<LottoNumber> publishLottoList() {
        resultList = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            LottoNumber lotto = new LottoNumber();
            lotto.generateNumbers();
            resultList.add(lotto);
        }
        return resultList;
    }

    public void checkNumber(String[] numbers) {
        issueStats = new HashMap<>();
        for (LottoNumber list: resultList) {
            setIssueStats(numbers, list);
        }
    }

    private void setIssueStats(String[] numbers, LottoNumber list) {
        LottoNumber lotto = new LottoNumber();
        int key = lotto.confrimLotto(list, numbers);
        int value = 1;
        if (issueStats.containsKey(key)){
            value = issueStats.get(key) + 1;
        }
        issueStats.put(key, value);
    }

    public List<LottoNumber> getResultList() {
        return resultList;
    }

    public Map<Integer, Integer> getIssueStats() {
        return issueStats;
    }
}