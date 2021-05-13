import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoModel {
    private List<Integer> numbers = new ArrayList<>();

    LottoModel(String manualNumbers) {
        String[] splitManualNumbers = splitBySeparator(manualNumbers);
        setManualLotto(splitManualNumbers);
    }

    public String[] splitBySeparator(String manualNumbers) {
        String separator = ", ";
        return manualNumbers.split(separator);
    }

    private int convertToInt(String number) {
        return Integer.parseInt(number);
    }

    private void setManualLotto(String[] manualNumbers) {
        for (int i = 0; i < manualNumbers.length; i++) {
            addNumber(convertToInt(manualNumbers[i]));
        }
    }

    LottoModel() {
        List<Integer> rangeOfNumbers = new ArrayList<>();
        for (int j = 0; j < 45; j++) {
            rangeOfNumbers.add(j + 1);
        }

        Collections.shuffle(rangeOfNumbers);
        for (int j = 0; j < 6; j++) {
            addNumber(rangeOfNumbers.get(j));
        }
        Collections.sort(numbers);
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
