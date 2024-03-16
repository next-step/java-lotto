package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {
    public static final Random RANDOM = new Random();
    private List <Number> numbers;

    public Lotto() {
        this.numbers = createNumbers();
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
}
