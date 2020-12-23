package lotto.domain;

import java.util.*;

public class lottoIssue {
    public final int amount;
    public lottoIssue(int amount) {
        this.amount = amount;
    }

    public int getCount() {
        return amount / 1000;
    }

    public Queue<List> publishLotto(int count) {
        Queue<List> result = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            result.add(selectionNumbers());
        }
        return result;
    }

    public List<Integer> selectionNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        List<Integer> chooseNum = new ArrayList<>(numbers.subList(0, 6));
        Collections.sort(chooseNum);
        return chooseNum;
    }
}
