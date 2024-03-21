package lotto.domain;

import lotto.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    public List<List<Integer>> createLottoList(int count) {
        List<List<Integer>> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(createLottoNumbers());
        }
        return lottoList;
    }

    public List<Integer> createLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            numbers.add(notDuplicateNumber(numbers));
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    public int notDuplicateNumber(List<Integer> numbers) {
        int number = RandomUtil.getRandom();
        while (numbers.contains(number)) {
            number = RandomUtil.getRandom();
        }
        return number;
    }

}
