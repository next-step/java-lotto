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

    public void checkNumber(String[] numbers, String bonus) {
        issueStats = new HashMap<>();
        int[] numberConvertInt = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            numberConvertInt[i] = Integer.parseInt(numbers[i]);
            vefiryCheckNumber(numberConvertInt, i);
        }
        for (LottoNumber issuelotto: resultList) {
            setIssueStats(issuelotto, numberConvertInt, bonus);
        }
    }

    private void vefiryCheckNumber(int[] numberConvertInt, int i) {
        if (numberConvertInt[i] >= 46) {
            throw new IllegalArgumentException("당첨 볼이 46보다 큽니다.");
        }
    }

    private void setIssueStats(LottoNumber issuelotto, int[] numbers, String bonus) {
        int key = getKey(issuelotto, numbers, bonus);
        int value = 1;
        if (issueStats.containsKey(key)){
            value = issueStats.get(key) + 1;
        }
        issueStats.put(key, value);
    }

    private int getKey(LottoNumber issuelotto, int[] numbers, String bonus) {
        int key = 0;
        int num = issuelotto.checkLotto(numbers, bonus);
        if (num == 6) {
            key = 1;
        }
        if (num == 5) {
            key = checkbonus(issuelotto);
        }
        if (num == 4) {
            key = 4;
        }
        if (num == 3) {
            key = 5;
        }
        return key;
    }

    private int checkbonus(LottoNumber issuelotto) {
        if (issuelotto.getBonusCheck()) {
            return 2;
        }
        return 3;
    }

    public List<LottoNumber> getResultList() {
        return resultList;
    }

    public Map<Integer, Integer> getIssueStats() {
        return issueStats;
    }
}