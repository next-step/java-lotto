package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
    public static List<Integer> generateNumbers() {
        List<Integer> numberCandidates = new ArrayList<>();

        for (int number = 1; number <= 45; number++) {
            numberCandidates.add(number);
        }

        Collections.shuffle(numberCandidates);

        List<Integer> ticketNumbers = new ArrayList<>();
        for (int index = 0; index < 6; index++) {
            ticketNumbers.add(numberCandidates.get(index));
        }

        return ticketNumbers;
    }
}