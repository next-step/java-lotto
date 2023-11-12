package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Game {

    private static final int LOTTO_NUMBER_SIZE = 45;

    private static final int GAME_NUMBER_SIZE = 6;

    private static final Set<Integer> lottoNumbers = new HashSet<>(LOTTO_NUMBER_SIZE);

    static {
        for (int idx = 1; idx <= LOTTO_NUMBER_SIZE; idx++) {
            lottoNumbers.add(idx);
        }
    }

    private final Set<Integer> numbers;

    public Game(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Game newGame() {
        Collections.shuffle(new ArrayList<>(lottoNumbers));
        Iterator<Integer> lottoGameNumberIterator = lottoNumbers.iterator();

        Set<Integer> values = new HashSet<>(GAME_NUMBER_SIZE);
        while (values.size() < GAME_NUMBER_SIZE) {
            values.add(lottoGameNumberIterator.next());
        }

        return new Game(values);
    }

    public int numberSize() {
        return numbers.size();
    }
}
