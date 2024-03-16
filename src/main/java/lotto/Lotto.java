package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {
    private static final Random RANDOM = new Random();
    private List<Number> numbers;

    public Lotto() {
        this.numbers = createNumbers();
    }

    public Lotto(List<Integer> winNumbers) {
        numbers = new ArrayList<>();
        winNumbers.forEach(number -> numbers.add(new Number(number)));
    }

    private static ArrayList<Number> createNumbers() {
        ArrayList<Number> arrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            arrayList.add(new Number(RANDOM.nextInt(46)));
        }
        return arrayList;
    }

    public int getNumberSize() {
        return numbers.size();
    }

    public long compareWinNumber(Lotto winNumber) {
        return numbers.stream()
                .filter(number -> winNumber.contains(number))
                .count();
    }

    private boolean contains(Number number) {
        return this.numbers.contains(number);
    }
}
