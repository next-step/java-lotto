package lotto.type;

import lotto.Lotto;

import java.util.*;

/**
 * 1부터 45사이의 (경계값 포함) 중복되지 않는 6개의 번호
 * 로또 번호 또는 당첨 번호로 쓰일 수 있습니다.
 * 불변 객체입니다.
 */
public class SixNumberComposition {
    private static final int NUMBER_LENGTH  = 6;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;

    private final List<Integer> numberList;

    private SixNumberComposition() {
        this.numberList = new ArrayList<>(NUMBER_LENGTH);
    }

    public static SixNumberComposition of(List<Integer> numberList) {
        validateLottoNumbers(numberList);

        SixNumberComposition numberComposition = new SixNumberComposition();
        numberComposition.numberList.addAll(numberList);
        numberComposition.numberList.sort(Comparator.naturalOrder());

        return numberComposition;
    }

    /**
     * 6번호 유효성 체크.
     * 문제가 없다면 통과되고, 문제가 있다면 예외가 던져집니다.
     */
    private static void validateLottoNumbers(List<Integer> numberList) {
        checkLength(numberList);

        for (int num : numberList) {
            checkRange(num);
        }

        checkDuplicate(numberList);
    }

    private static void checkDuplicate(List<Integer> numberList) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int number : numberList) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("Duplicate number found: " + number);
            }
        }
    }

    private static void checkRange(int num) {
        if (num < MIN_NUM) {
            throw new IllegalArgumentException("주어진 번호는 " + num + "로 "+MIN_NUM+" 미만입니다.");
        }

        if (num > MAX_NUM) {
            throw new IllegalArgumentException("주어진 번호는 " + num + "로 "+MAX_NUM+" 초과입니다.");
        }
    }

    private static void checkLength(List<Integer> numberList) {
        if (numberList.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("주어진 숫자가 " + NUMBER_LENGTH + "개가 아니라 " + numberList.size() + "개입니다.");
        }
    }

    @Override
    public String toString() {
        return "SixNumberComposition{" +
                "numberList=" + numberList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SixNumberComposition that = (SixNumberComposition) o;

        return Objects.equals(numberList, that.numberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberList);
    }

    /**
     * 이 번호 조합이 주어진 번호를 가지고 있는지 확인합니다.
     *
     * @param num 확인할 번호
     * @return 가지고 있다면 true
     */
    public boolean contains(int num) {
        return this.numberList.contains(num);
    }

    /**
     * 이 타입과 호환되지 않는 곳에서 사용하기 위해 숫자 목록을 리스트로 만듭니다.
     *
     * @return 숫자 리스트
     */
    public List<Integer> toList() {
        return List.copyOf(this.numberList);
    }
}