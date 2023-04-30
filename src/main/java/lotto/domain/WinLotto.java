package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinLotto {
    private final List<Integer> numbers = new ArrayList<>();

    public WinLotto(String inputString) {
        String[] strNumbers = inputString.split(LottoRule.SPLIT_DELIMITER);
        for (String strNumber : strNumbers) {
            //TODO : 입력된 숫자 유효성 검사 로직 필요 (숫자 타입, 숫자 개수, 숫자 범위)
            numbers.add(Integer.valueOf(strNumber));
        }
        Collections.sort(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> numbers() {
        return numbers;
    }

    public Integer number(int i) {
        return numbers.get(i);
    }
}
