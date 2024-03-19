package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private final List<Integer> numbers = new ArrayList<>();

    public LottoNumbers(String input) {
        validNull(input);
        splitNumbers(input);
        validNumberCount();
    }

    public LottoNumbers(List<Integer> numbersInput) {
        numbers.addAll(numbersInput);
        validNumberCount();
    }

    private void validNull(String nums) {
        if (nums == null) {
            throw new IllegalArgumentException("당첨 번호는 null이면 안됩니다.");
        }
    }

    private void splitNumbers(String numbers) {
        String[] splitArray = numbers.split(", ");
        for (String num : splitArray) {
            insertNumbers(num);
        }
    }

    private void insertNumbers(String number) {
        isNumeric(number);
        numbers.add(Integer.parseInt(number));
    }

    private void isNumeric(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    private void validNumberCount() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 형식과 맞는 숫자 개수를 입력하세요.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
