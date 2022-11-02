package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int AMOUNT = 1000;
    public static final int TOTAL_NUMBERS = 6;
    private static final int LAST_NUMBER = 45;

    private final int purchaseCount;
    private final List<Integer> allNumbers;
    private final List<List<Integer>> numbers;

    public Lotto(int purchaseAmount) {
        purchaseCount = purchaseAmount / AMOUNT;
        this.numbers = new ArrayList<>(purchaseCount);
        allNumbers = IntStream.range(1, LAST_NUMBER + 1).boxed().collect(Collectors.toList());
    }

    public void generateNumbers() {
        for (int i=0 ; i<purchaseCount ; i++) {
            Collections.shuffle(allNumbers);
            List<Integer> newNumbers = new ArrayList<>(List.copyOf(allNumbers.subList(0, TOTAL_NUMBERS)));
            newNumbers.sort(Comparator.naturalOrder());
            numbers.add(i, newNumbers);
        }
    }

    public void printNumbers() {
        for (List<Integer> targetNumbers : numbers) {
            System.out.print("[");
            printEachNumber(targetNumbers);
            System.out.println("]");
        }
        System.out.println();
    }

    private void printEachNumber(List<Integer> targetNumbers) {
        for (int j = 0; j < targetNumbers.size(); j++) {
            System.out.print(targetNumbers.get(j));
            printComma(j, targetNumbers.size() - 1);
        }
    }

    private void printComma(int index, int endIndex) {
        if (index < endIndex) {
            System.out.print(", ");
        }
    }

    public int getNumbersSize() {
        return this.numbers.size();
    }

    public List<List<Integer>> getNumbers() {
        return this.numbers;
    }

    public int getPurchaseCount() {
        return this.purchaseCount;
    }
}
