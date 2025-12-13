package lotto.util;

import lotto.domain.LottoNumber;

import java.util.*;

public class LottoNumberParser {
    private static final String SPLIT_REGELX = "[,\\s]+";
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static List<LottoNumber> parse(String input) {
        String[] splittedNumbers = input.split(SPLIT_REGELX);
        for (String splittedNumber : splittedNumbers) {
            System.out.println(splittedNumber);
        }
        if (!isValidInput(splittedNumbers)) {
            throw new IllegalArgumentException("정상적인 입력이 아닙니다.");
        }

        return parse(splittedNumbers);
    }

    public static List<LottoNumber> parse(String[] numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (String number : numbers) {
            lottoNumbers.add(LottoNumberCache.get(number));
        }

        return lottoNumbers;
    }

    public static List<LottoNumber> parse (int... numbers) {
        List<LottoNumber> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(LottoNumberCache.get(number));
        }

        return list;
    }

    public static List<LottoNumber> parse(List<Integer> numbers) {
        List<LottoNumber> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(LottoNumberCache.get(number));
        }
        return list;
    }

    private static boolean isValidInput(String[] input) {
        return isInputNumberCountSIX(input) && !hasDuplicate(input);
    }

    private static boolean isInputNumberCountSIX(String[] input) {
        return input.length == LOTTO_NUMBER_COUNT;
    }

    private static boolean hasDuplicate(String[] input) {
        Set<String> uniqueNumbers = new HashSet<>(Arrays.asList(input));
        return uniqueNumbers.size() != input.length;
    }
}
