package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {

    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final String NUMBER_REX_PATTERN = ", ";
    private static final String LOTTO_RANGE_ERROR_TEXT = "로또 번호는 1이상 45이하 여야 합니다.";
    private static final String LOTTO_NUMBER_SIZE_ERROR_TEXT = "로또 번호는 6개의 숫자가 필요합니다.";
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> list;

    public LottoNumber(String numbers) {
        this.list = Arrays.stream(numbers.split(NUMBER_REX_PATTERN))
                .map(Integer::parseInt)
                .filter(this::filter)
                .collect(Collectors.toList());
        validListSize();
    }

    public LottoNumber(List<Integer> numbers) {
        this.list = numbers.stream()
                .filter(this::filter)
                .collect(Collectors.toList());
        validListSize();
    }

    public List<Integer> getList() {
        list.sort(Comparator.naturalOrder());
        return Collections.unmodifiableList(list);
    }

    private boolean filter(int number) {
        if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) throw new IllegalArgumentException(LOTTO_RANGE_ERROR_TEXT);
        return true;
    }

    private void validListSize() {
        if (this.list.size() != LOTTO_NUMBER_SIZE) throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR_TEXT);
    }

}
