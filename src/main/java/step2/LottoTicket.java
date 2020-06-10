package step2;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private List<Integer> numbers;

    public LottoTicket() {
        numbers = new ArrayList<>();
    }

    public void addLottoNumber(int number) {
        numbers.add(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (Integer number : numbers) {
            stringBuilder.append(number).append(",");
        }

        int lastCommaIndex = stringBuilder.lastIndexOf(",");
        stringBuilder.deleteCharAt(lastCommaIndex);

        return stringBuilder.toString();
    }
}
