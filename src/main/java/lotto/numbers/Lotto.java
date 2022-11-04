package lotto.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lotto.numbers.AllNumbers;

public class Lotto {
    public static final int TOTAL_NUMBERS_SIZE = 6;

    private final List<List<Integer>> numbers;

    public Lotto(int purchaseCount) {
        this.numbers = new ArrayList<>(purchaseCount);
    }

    public void generateNumbers(int purchaseCount) {
        List<Integer> allNumbers = AllNumbers.getNumbers();
        for (int i=0 ; i<purchaseCount ; i++) {
            Collections.shuffle(allNumbers);
            List<Integer> newNumbers = new ArrayList<>(List.copyOf(allNumbers.subList(0, TOTAL_NUMBERS_SIZE)));
            newNumbers.sort(Comparator.naturalOrder());
            numbers.add(i, newNumbers);
        }
    }

    public boolean containsNumber(int index, int number) {
        return numbers.get(index).contains(number);
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
}
