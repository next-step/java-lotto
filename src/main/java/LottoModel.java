import java.util.List;

public class LottoModel {
    private List<Integer> numbers;

    LottoModel(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int setWinningResult(List<Integer> winningNumbers) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (numbers.contains(winningNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }
}
