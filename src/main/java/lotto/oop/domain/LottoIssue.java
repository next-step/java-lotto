package lotto.oop.domain;

import java.util.*;

public class LottoIssue {
    public static final int FROM_INDEX = 0;
    public static final int TO_INDEX = 6;
    private int count;
    private Queue<ArrayList> result;
    public LottoIssue(int count) {
        this.count = count;
    }

    public int publishLottoList() {
        result = new LinkedList<>();
        for(int i = 0; i < count; i++) {
            result.add(generateNumbers());
        }
        return result.size();
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
}
