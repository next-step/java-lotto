package lotto;

import lotto.type.SingleNumber;
import lotto.type.SixNumberComposition;

import java.util.*;

/**
 * 로또 한 장입니다.
 */
public class Lotto {
    private SixNumberComposition lottoNumbers;

    private Lotto() {
    }

    /**
     * 주어진 번호로 로또 한 장을 생성합니다. 당연히 주어지는 리스트는 길이가 딱 6이어야 합니다.
     *
     * @param numberList 로또 번호
     *
     * @return 생성된 로또
     */
    public static Lotto of(List<Integer> numberList) {
        Lotto lotto = new Lotto();
        lotto.lottoNumbers = SixNumberComposition.ofByInt(numberList);

        return lotto;
    }

    /**
     * 이 로또 용지가 주어진 번호를 가지고 있는지 확인합니다.
     *
     * @param num 확인할 번호
     * @return 가지고 있다면 true
     */
    boolean contains(SingleNumber num) {
        return lottoNumbers.contains(num);
    }

    /**
     * 이 로또 용지가 주어진 번호 목록 중 몇 개나 가지고 있는지 확인합니다.
     *
     * @param nums 확인할 번호 목록
     * @return 로또 용지가 가지고 있는 번호 개수
     */
    int howManyContain(List<SingleNumber> nums) {
        int containCount = 0;
        for (SingleNumber num : nums) {
            containCount += this.contains(num) ? 1 : 0;
        }
        return containCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lotto lotto = (Lotto) o;

        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + lottoNumbers +
                '}';
    }

    /**
     * 로또 번호를 리스트로 만듭니다.
     *
     * @return 로또 번호 리스트
     */
    public List<Integer> toList() {
        List<SingleNumber> numbers = this.lottoNumbers.toList();

        List<Integer> primitiveInts = new ArrayList<>();
        for (SingleNumber number : numbers) {
            primitiveInts.add(number.toInt());
        }

        return primitiveInts;
    }
}