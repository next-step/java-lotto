package lotto.domain;

import java.util.*;

public class lottoIssue {
    public final int amount;
    private Queue<ArrayList> result;
    public int count;
    private HashMap<Integer, Integer> lottoStats;

    public lottoIssue(int amount) {
        this.amount = amount;
    }

    public Queue<ArrayList> publishLotto(int count) {
        result = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            result.add(selectionNumbers());
        }
        return result;
    }

    public ArrayList<Integer> selectionNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        ArrayList<Integer> chooseNum = new ArrayList<>(numbers.subList(0, 6));
        Collections.sort(chooseNum);
        return chooseNum;
    }

    public void checkLotto(String[] numList) {
        lottoStats = new HashMap<Integer, Integer>();
        for (ArrayList list: result) {
            int key = confrimLotto(list, numList);
            int value = 1;
            if (lottoStats.containsKey(key)){
                value = lottoStats.get(key) + 1;
            }
            lottoStats.put(key, value);
        }
    }

    public int confrimLotto(ArrayList list, String[] numList) {
        count = 0;
        for (int i = 0; i < numList.length; i++) {
            verifyNumCount(list, numList, i);
        }
        return count;
    }

    private void verifyNumCount(ArrayList list, String[] numList, int i) {
        if (list.contains(Integer.parseInt(numList[i]))) {
            ++count;
        }
    }

    public int getCount() {
        return amount / 1000;
    }

    public Queue<ArrayList> getResult() {
        return result;
    }

    public HashMap<Integer, Integer> getLottoStats() {
        return lottoStats;
    }
}
