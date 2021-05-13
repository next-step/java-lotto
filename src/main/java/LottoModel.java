import java.util.List;

public class LottoModel {
    private List<Integer> numbers;

    LottoModel() {
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countWinningNumbers(List<Integer> winningNumbers) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (numbers.contains(winningNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }
}
