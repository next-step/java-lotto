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
        for (String splitNumber : splitNumbers) {
            numbers.add(Integer.parseInt(splitNumber));
        }
    }

    public int getNumber(int index){
        return this.numbers.get(index);
    }

    public List<Integer> getNumberList(){
        return Collections.unmodifiableList(this.numbers);
    }

    public void matchNumber(int lottoNumber, LottosComparer lottosComparer){
        for (int i = 0; i < 6; i++) {
            compareNumber(lottoNumber, this.numbers.get(i), lottosComparer);
        }
    }

    private void compareNumber(int lottoNumber, int winningNumber, LottosComparer lottosComparer){
        if (winningNumber == lottoNumber) {
            lottosComparer.addMatchingCount();
        }
    }
}
