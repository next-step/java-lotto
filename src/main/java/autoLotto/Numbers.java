package autoLotto;

import java.util.List;

public class Numbers {

    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 숫자는 6개 입력 해야합니다.");
        }

        for (Integer number : numbers) {
//            if (number > 45) {
//                throw new IllegalArgumentException("당청 숫자는 1 ~ 45만 입력 가능합니다.");
//            }
        }
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
