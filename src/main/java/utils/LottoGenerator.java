package utils;

import java.util.*;

public class LottoGenerator {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;

    public static List<Integer> generateNumberList(int lottoCount) {
        List<Integer> numbers = getLottoNumInit();

        numbers = getShuffle(numbers, lottoCount);
        if (isDuplication(numbers)) {
            throw new RuntimeException("중복번호입니다.");
        }
        return numbers;
    }

    private static List<Integer> getShuffle(List<Integer> numbers, int lottoCount) {
        Collections.shuffle(numbers, new Random());
        numbers = numbers.subList(0, lottoCount);
        Collections.sort(numbers);
        return numbers;
    }

    private static List<Integer> getLottoNumInit() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = LOTTO_MIN_NUM; i <= LOTTO_MAX_NUM; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private static boolean isDuplication(List<Integer> numbers) {
        return numbers.stream().count() != numbers.stream().distinct().count();
    }

}
