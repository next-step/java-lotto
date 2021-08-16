package lotto;

import java.util.Arrays;

public class Lotto {
    private int[] randomNumbers;

    public Lotto() {
        randomNumbers = new int[] {1,2,3,4,5,6};
    }


    @Override
    public String toString() {
        return Arrays.toString(randomNumbers);
    }
}
