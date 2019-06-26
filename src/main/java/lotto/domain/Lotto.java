package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    protected List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto() {
        this(new ArrayList<>());
    }

    void checkAnotherNumberLength(List<Integer> numbers) throws IllegalArgumentException {
        Set anotherNums = new HashSet();
        for (Integer number : numbers) {
            anotherNums.add(number);
        }
        if (anotherNums.size() != LottoNumber.MAX_LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("1부터 45사이의 서로 다른 6개의 숫자만 로또번호로 인정됩니다.");
        }
    }

    Rank getRank(List<Integer> winNumbers) {
        int sameWinNumberCount = 0;
        for (Integer winNumber : winNumbers) {
            sameWinNumberCount = getSameWinNumbers(winNumber, sameWinNumberCount);
        }
        return Rank.valueOf(sameWinNumberCount);
    }

    private int getSameWinNumbers(Integer winNumber, int sameWinNumberCount) {
        if (numbers.contains(winNumber)) {
            sameWinNumberCount++;
        }
        return sameWinNumberCount;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
