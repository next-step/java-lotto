package lotto.util;

import lotto.domain.LottoNumber;

import java.util.*;

public class Duplicated {

    public static boolean hasDuplicatedNumber(int[] numbers) {
        Set<Integer> nums = new HashSet<>();
        Collections.addAll(nums, Arrays.stream(numbers).boxed().toArray(Integer[]::new));
        return nums.size() != numbers.length;
    }

    public static boolean hasDuplicatedNumber(String[] numbers) {
        Set<String> strings = new HashSet<>();
        Collections.addAll(strings, numbers);
        return strings.size() != numbers.length;
    }

    public static boolean hasDuplicatedNumber(List<LottoNumber> numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(numbers);
        return lottoNumbers.size() != numbers.size();
    }
}
