package lotto;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private int number1;
    private int number2;
    private int number3;
    private int number4;
    private int number5;
    private int number6;


    public LottoTicket(List<Integer> numbers) {
        checkSizeNumbers(numbers);
        checkUniqueNumbers(numbers);
        checkBoundaryNumbers(numbers);
        Collections.sort(numbers);
        this.number1 = numbers.get(0);
        this.number2 = numbers.get(1);
        this.number3 = numbers.get(2);
        this.number4 = numbers.get(3);;
        this.number5 = numbers.get(4);;
        this.number6 = numbers.get(5);;
    }

    private void checkUniqueNumbers(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복 값은 입력할 수 없습니다.");
        }
    }

    private void checkBoundaryNumbers(List<Integer> numbers) {
        if(!numbers.stream().allMatch(number -> number >=1 && number <=45)) {
            throw new IllegalArgumentException("1이상 45이하의 숫자만 입력할 수 있습니다.");
        }
    }

    private void checkSizeNumbers(List<Integer> numbers) {
        if(numbers.size()!=6) {
            throw new IllegalArgumentException("로또 생성을 위해서는 6개의 숫자가 필요합니다.");
        }
    }

    @Override
    public String toString() {
        return "[" + number1 + ", " + number2 + ", " + number3 + ", " + number4 + ", " + number5 + ", " + number6 + "]";
    }
}
