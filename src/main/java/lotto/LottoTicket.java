package lotto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private  List<Integer> numbers;

    public static LottoTicket createTicket(List<Integer> inputs) {
        checkSizeNumbers(inputs);
        checkUniqueNumbers(inputs);
        checkBoundaryNumbers(inputs);
        Collections.sort(inputs);
        return new LottoTicket(inputs);
    }
    private LottoTicket(List<Integer> inputs) {
        this.numbers = inputs;
    }

    private static void checkUniqueNumbers(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복 값은 입력할 수 없습니다.");
        }
    }

    private static void checkBoundaryNumbers(List<Integer> numbers) {
        if(!numbers.stream().allMatch(number -> number >=1 && number <=45)) {
            throw new IllegalArgumentException("1이상 45이하의 숫자만 입력할 수 있습니다.");
        }
    }

    private static void checkSizeNumbers(List<Integer> numbers) {
        if(numbers.size()!=6) {
            throw new IllegalArgumentException("로또 생성을 위해서는 6개의 숫자가 필요합니다.");
        }
    }

//    public List<Integer> displayNumbers() {
//        return Collections.unmodifiableList(numbers);
//    }

    public List<Integer> displayNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
