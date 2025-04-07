package domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Integer> numbers;

    public LottoTicket() {
        numbers = generateRandomNumbers();
    }

    public LottoTicket(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers); // 정렬은 선택
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

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}

