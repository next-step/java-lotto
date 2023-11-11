package lotto.domain;

import java.util.*;

public class Lotto {

    public static final int COUNT = 6;

    private List<Integer> numbers;

    public Lotto(NumberGeneration numberGeneration) {
        this.numbers = makeLotto(numberGeneration);
    }

    public static List<Integer> makeLotto(NumberGeneration numberGeneration) {
        return numberGeneration.generate();
    }

    public int isWinning(List<Integer> winingList) {
        for (int i = 0; i < COUNT; i++) {
            if (isNotEqual(winingList.get(i), numbers.get(i))) {
                return 0;
            }
        }
        return 1;
    }

    private boolean isNotEqual(int winNumber, int lottoNumber) {
        if (winNumber != lottoNumber) {
            return true;
        }
        return false;
    }


    public int countMatchNumber(List<Integer> winningList) {
        int count = 0;
        for (int i = 0; i < COUNT; i++) {
            if (winningList.get(i).equals(numbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public String findNumbersForPrint() {
        Collections.sort(numbers);
        return numbers.toString();
    }
}