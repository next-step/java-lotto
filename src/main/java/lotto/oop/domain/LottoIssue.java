package lotto.oop.domain;

import java.util.*;

public class LottoIssue {
    public static final int FROM_INDEX = 0;
    public static final int TO_INDEX = 6;
    private int count;
    private Queue<ArrayList> result;
    private Map<Integer, Integer> issueStats;

    public LottoIssue(int count) {
        this.count = count;
    }

    public Queue<ArrayList> publishLottoList() {
        result = new LinkedList<>();
        for(int i = 0; i < count; i++) {
            result.add(generateNumbers());
        }
        return result;
    }

    private ArrayList<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        ArrayList<Integer> chosenNum = new ArrayList<>(numbers.subList(FROM_INDEX, TO_INDEX));
        Collections.sort(chosenNum);
        return chosenNum;
    }

    public void checkNumber(String[] numbers) {
        issueStats = new HashMap<>();
        for (ArrayList list: result) {
            int key = confrimLotto(list, numbers);
            int value = 1;
            if (issueStats.containsKey(key)){
                value = issueStats.get(key) + 1;
            }
            issueStats.put(key, value);
        }
    }

    public int confrimLotto(ArrayList list, String[] numbers) {
        count = 0;
        for (int i = 0; i < numbers.length; i++) {
            verifyNumCount(list, numbers, i);
        }
        return count;
    }

    private void verifyNumCount(ArrayList list, String[] numList, int i) {
        if (list.contains(Integer.parseInt(numList[i]))) {
            ++count;
        }
    }

    public Map<Integer, Integer> getIssueStats() {
        return issueStats;
    }
}
