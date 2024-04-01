package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers create(String[] no) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < no.length; i += 2) {
            list.add(Integer.parseInt(no[i]));
        }
        if (list.isEmpty()) {
            throw new RuntimeException("입력된 숫자가 없습니다.");
        }
        return new Numbers(list);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
  
    public int of(int index) {
        return numbers.get(index);
    }
}
