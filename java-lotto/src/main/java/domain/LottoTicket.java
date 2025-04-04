package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Integer> numbers;

    public LottoTicket() {
        numbers = generateRandomNumbers();
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> allNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            allNumbers.add(i);
        }
        Collections.shuffle(allNumbers);
        List<Integer> selectedNumbers = allNumbers.subList(0, 6);
        Collections.sort(selectedNumbers);
        return selectedNumbers;
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}

