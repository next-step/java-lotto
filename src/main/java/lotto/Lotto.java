package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Lotto {

    public static final Map<Integer, Integer> prize = new LinkedHashMap<>();
    static {
        prize.put(3, 5_000);
        prize.put(4, 50_000);
        prize.put(5, 1_500_000);
        prize.put(6, 2_000_000_000);
    }

    private static final List<Integer> numbers = Arrays.asList(
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
        21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
        31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
        41, 42, 43, 44, 45, 46
    );

    private List<Integer> ticket = new ArrayList<>();

    public Lotto(){
        shuffle();
    }

    private void shuffle() {
        List<Integer> draw = new ArrayList<>(numbers);
        Collections.shuffle(draw);
        ticket.addAll(draw.subList(1, 7));
        ticket.sort(Comparator.naturalOrder());
    }

    public int getResult(Integer[] winningNumbers){
        return (int) Arrays.stream(winningNumbers)
            .filter(number -> ticket.contains(number))
            .count();
    }

    @Override
    public String toString() {
        return Arrays.toString(ticket.toArray());
    }
}
