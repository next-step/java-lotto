package autolotto.model;

import autolotto.exception.IsNotSixNumberException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers = new ArrayList<>();

    public Lotto() {
        List<Integer> tempNumbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            tempNumbers.add(i);
        }

        Collections.shuffle(tempNumbers);

        for (int i = 0; i < 6; i++) {
            numbers.add(tempNumbers.get(i));
        }

        Collections.sort(numbers);
    }

    public Lotto(String[] splitNumbers) {
        for (int i = 0; i < splitNumbers.length; i++) {
            numbers.add(Integer.parseInt(splitNumbers[i]));
        }
    }

    public int getNumber(int index){
        return this.numbers.get(index);
    }

    public List<Integer> getNumberList(){
        return Collections.unmodifiableList(this.numbers);
    }
}
