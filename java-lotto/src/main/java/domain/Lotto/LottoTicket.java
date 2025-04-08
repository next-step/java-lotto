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
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers); // 정렬은 선택
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        long uniqueCount = numbers.stream().distinct().count();
        if (uniqueCount != 6) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }

        boolean allInRange = numbers.stream().allMatch(n -> n >= 1 && n <= 45);
        if (!allInRange) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
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

    public int countMatchingNumbersWith(LottoTicket winningTicket) {
        return (int) numbers.stream()
                .filter(winningTicket::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}

