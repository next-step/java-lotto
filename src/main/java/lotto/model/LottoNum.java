package lotto.model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNum {
    public static final int RANDOM_NUM_MAX = 45;
    public static final int RANDOM_NUM_MIN = 1;
    private static final int SIZE = 6;
    private static final Map<Integer, LottoNum> LOTTO_NUM_MAP = IntStream.rangeClosed(LottoNum.RANDOM_NUM_MIN, LottoNum.RANDOM_NUM_MAX)
            .mapToObj(LottoNum::new)
            .collect(Collectors.toMap(LottoNum::getNum, Function.identity()));
    private static final List<LottoNum> LOTTO_NUMS = LottoNum.LOTTO_NUM_MAP.entrySet().stream()
            .map(Map.Entry::getValue)
            .collect(Collectors.toList());

    private int num;

    public LottoNum(int num) {
        validateRange(num);

        this.num = num;
    }

    private static void validateRange(int num) {
        if (!isWithinRange(num)) {
            System.out.println("adsad : "+num);
            throw new IllegalArgumentException("숫자는" + RANDOM_NUM_MIN + "과 " + RANDOM_NUM_MAX + "사이여햐합니다.");
        }
    }

    /**
     * 범위 이내인가?
     * @param num
     * @return
     */
    private static boolean isWithinRange(int num) {
        return RANDOM_NUM_MIN <= num && num <= RANDOM_NUM_MAX;
    }

    /**
     * 랜덤 숫자 가져오기
     *
     * @return
     */
    public static List<LottoNum> getRandNums() {
        Collections.shuffle(LOTTO_NUMS);
        return LOTTO_NUMS.stream()
                .limit(SIZE)
                .collect(Collectors.toList());
    }

    /**
     * 로또 번호들로 변경
     * @param nums
     * @return
     */
    public static List<LottoNum> toLottoNums(List<Integer> nums) {
        return nums.stream()
                .map(LottoNum::toLottoNum)
                .collect(Collectors.toList());
    }

    /**
     * 로또 번호로 변경
     * @param num
     * @return
     */
    public static LottoNum toLottoNum(Integer num) {
        validateRange(num);

        return LOTTO_NUM_MAP.get(num);
    }

    public int getNum() {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNum lottoNum = (LottoNum) o;
        return num == lottoNum.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
