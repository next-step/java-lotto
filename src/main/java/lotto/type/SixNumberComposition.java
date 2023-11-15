package lotto.type;

import java.util.*;

/**
 * 1부터 45사이의 (경계값 포함) 중복되지 않는 6개의 번호
 * 로또 번호 또는 당첨 번호로 쓰일 수 있습니다.
 * 불변 객체입니다.
 */
public class SixNumberComposition {
    private static final int NUMBER_LENGTH  = 6;

    private final List<SingleNumber> singleNumbers;

    private SixNumberComposition() {
        this.singleNumbers = new ArrayList<>(NUMBER_LENGTH);
    }

    public static SixNumberComposition ofByInt(List<Integer> numbers) {
        List<SingleNumber> singleNumbers = new ArrayList<>();

        for (int number : numbers) {
            singleNumbers.add(SingleNumber.of(number));
        }

        return SixNumberComposition.of(singleNumbers);
    }

    public static SixNumberComposition of(List<SingleNumber> singleNumbers) {
        validateLottoNumbers(singleNumbers);

        SixNumberComposition sixLottoNumbers = new SixNumberComposition();
        sixLottoNumbers.singleNumbers.addAll(singleNumbers);
        sixLottoNumbers.singleNumbers.sort(Comparator.naturalOrder());

        return sixLottoNumbers;
    }

    /**
     * 6번호 유효성 체크.
     * 문제가 없다면 통과되고, 문제가 있다면 예외가 던져집니다.
     */
    private static void validateLottoNumbers(List<SingleNumber> singleNumbers) {
        checkLength(singleNumbers);
        checkDuplicate(singleNumbers);
    }

    private static void checkDuplicate(List<SingleNumber> singleNumbers) {
        Set<SingleNumber> uniqueNumbers = new HashSet<>();

        for (SingleNumber number : singleNumbers) {
            checkNotIn(number, uniqueNumbers);
        }
    }

    private static void checkNotIn(SingleNumber number, Set<SingleNumber> uniqueNumbers) {
        if (!uniqueNumbers.add(number)) {
            throw new IllegalArgumentException("Duplicate number found: " + number);
        }
    }


    private static void checkLength(List<SingleNumber> singleNumbers) {
        if (singleNumbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("주어진 숫자가 " + NUMBER_LENGTH + "개가 아니라 " + singleNumbers.size() + "개입니다.");
        }
    }

    /**
     * 이 번호 조합이 주어진 번호를 가지고 있는지 확인합니다.
     *
     * @param num 확인할 번호
     * @return 가지고 있다면 true
     */
    public boolean contains(SingleNumber num) {
        return this.singleNumbers.contains(num);
    }

    /**
     * 6개 조합 숫자 목록을 평탄화 하여 그냥 숫자 목록으로 만듭니다.
     *
     * @return 숫자 리스트
     */
    public List<SingleNumber> toList() {
        return List.copyOf(this.singleNumbers);
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

        return singleNumbers.equals(that.singleNumbers);
    }

    @Override
    public int hashCode() {
        return singleNumbers.hashCode();
    }

    @Override
    public String toString() {
        return "SixLottoNumber{" +
                "lottoNumbers=" + singleNumbers +
                '}';
    }
}