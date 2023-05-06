package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Lotto {
    private ArrayList<Integer> lotto = new ArrayList<>();

    public Lotto() {

    }

    public Lotto(ArrayList<Integer> lotto) {
        this.lotto = lotto;
    }

    public ArrayList<Integer> getLotto() {
        return this.lotto;
    }

    public void makeRandomLotto() {
        ArrayList<Integer> numbers = getNum1to45();

        Collections.shuffle(numbers);

        addLotto(numbers);
    }

    public void addLotto(ArrayList<Integer> numbers) {
        for (int i = 0; i < 6; i++) {
            lotto.add(numbers.get(i));
        }
    }

    private static ArrayList<Integer> getNum1to45() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        return numbers;
    }

}
