package utils;

import domain.Lotto;
import domain.wrapper.LottoNo;

import java.util.*;

public class LottoGenerator {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_COUNT = 6;

    public static Lotto generateNumberList(int lottoCount) {
        List<Integer> numbers = getLottoNumInit();

        numbers = getShuffle(numbers, lottoCount);
        if (isDuplication(numbers)) {
            throw new RuntimeException("중복번호입니다.");
        }
        return new Lotto(numbers);
    }

//    public static List<Integer> generateNumberList(int lottoCount) {
//        List<Integer> numbers = getLottoNumInit();
//
//        numbers = getShuffle(numbers, lottoCount);
//        if (isDuplication(numbers)) {
//            throw new RuntimeException("중복번호입니다.");
//        }
//        return numbers;
//    }

//    public static List<LottoNo> generateNumberList(int lottoCount) {
//        List<LottoNo> numbers = getLottoNumInit();
//
//        numbers = getShuffle(numbers, lottoCount);
//        if (isDuplication(numbers)) {
//            throw new RuntimeException("중복번호입니다.");
//        }
//        return numbers;
//    }

//    private static List<LottoNo> getShuffle(List<LottoNo> numbers, int lottoCount) {
//        Collections.shuffle(numbers, new Random());
//        numbers = numbers.subList(0, lottoCount);
//        return numbers;
//    }

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

//    private static List<LottoNo> getLottoNumInit() {
//        List<LottoNo> numbers = new ArrayList<>();
//        for (int i = LOTTO_MIN_NUM; i <= LOTTO_MAX_NUM; i++) {
//            numbers.add(new LottoNo(i));
//        }
//        return numbers;
//    }

    public static boolean isDuplication(List<Integer> numbers) {
        return numbers.stream().count() != LOTTO_COUNT;
    }

//    public static boolean isDuplication(List<LottoNo> numbers) {
//        return numbers.stream().count() != LOTTO_COUNT;
//    }

}
