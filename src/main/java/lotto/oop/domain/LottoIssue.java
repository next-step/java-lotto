package lotto.oop.domain;

import java.util.*;

public class LottoIssue {
    public static final int FROM_INDEX = 0;
    public static final int TO_INDEX = 6;

    private List<LottoNumber> resultList = new ArrayList<>();
    private Map<Rank, Integer> issueStats;

    public LottoIssue() {
        issueStats = new HashMap<>();
        issueStats.put(Rank.FIRST, 0);
        issueStats.put(Rank.SECOND, 0);
        issueStats.put(Rank.THIRD, 0);
        issueStats.put(Rank.FOURTH, 0);
        issueStats.put(Rank.FIFTH, 0);
        issueStats.put(Rank.MISS, 0);
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
        for (LottoNumber issuelotto: resultList) {
            setIssueStats(issuelotto, winNumbers, bonusNumber);
        }
    }

    private void vefiryCheckNumber(List<Integer> winNumbers, int i) {
        if (winNumbers.get(i) >= 46 || winNumbers.get(i) <= 0) {
            throw new IllegalArgumentException("당첨 볼이 46보다 큽니다.");
        }
    }

    private void setIssueStats(LottoNumber issuelotto, List<Integer> numbers, int bonus) {
        int key = getKey(issuelotto, numbers, bonus);
        Rank rank = Rank.valueOf(key, issuelotto.getBonusCheck());
        issueStats.put(rank, issueStats.get(rank) + 1);
    }

    private int getKey(LottoNumber issuelotto, List<Integer> numbers, int bonus) {
        return issuelotto.checkLotto(numbers, bonus);
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

    public Map<Rank, Integer> getIssueStats() {
        return issueStats;
    }
}