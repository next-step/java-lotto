package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class God {

    public static List<Integer> issueNumbers(int upperbound, int count) {
        if (count > upperbound) throw new IllegalArgumentException();
        List<Integer> generatedNumbers = generateNumbers(upperbound);
        Collections.shuffle(generatedNumbers);

        List<Integer> chosenNumbers = new ArrayList<>();
        IntStream.range(0, count)
                .forEach(val -> chosenNumbers.add(generatedNumbers.get(val)));
        Collections.sort(chosenNumbers);
        return chosenNumbers;
    }

    private static List<Integer> generateNumbers(int upperbound) {
        List<Integer> generatedNumbers = new ArrayList<>();
        IntStream.range(1, upperbound + 1)
                .forEach(generatedNumbers::add);
        return generatedNumbers;
    }

}
