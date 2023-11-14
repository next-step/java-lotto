package lotto;

import java.util.*;

/**
 * 로또 한 장입니다.
 */
public class Lotto {
    /** 로또 한 장이 몇 개의 번호로 구성되는지를 나타냅니다. */
    private static final int LOTTO_NUMBER_COUNT = 6;

    List<Integer> numberList = new ArrayList<>(LOTTO_NUMBER_COUNT);

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
        if (numberList.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("주어진 숫자가 "+LOTTO_NUMBER_COUNT+"개가 아니라 " + numberList.size() + "개입니다.");
        }

        Lotto lotto = new Lotto();
        lotto.numberList.addAll(numberList);
        lotto.numberList.sort(Comparator.naturalOrder());

        lotto.validateLottoNumbers();

        return lotto;
    }

    /**
     * 로또 번호 유효성 체크.
     * 문제가 없다면 통과되고, 문제가 있다면 예외가 던져집니다.
     */
    private void validateLottoNumbers() {
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            if (numberList.get(i) < 1) {
                throw new IllegalArgumentException("주어진 로또 번호는 " + numberList.get(i) + "로 1 미만입니다.");
            }

            if (numberList.get(i) > 45) {
                throw new IllegalArgumentException("주어진 로또 번호는 " + numberList.get(i) + "로 45 초과입니다.");
            }
        }
    }


    /**
     * 이 로또 용지가 주어진 번호를 가지고 있는지 확인합니다.
     *
     * @param num 확인할 번호
     * @return 가지고 있다면 true
     */
    boolean contains(int num) {
        return numberList.contains(num);
    }

    /**
     * 이 로또 용지가 주어진 번호 목록 중 몇 개나 가지고 있는지 확인합니다.
     *
     * @param nums 확인할 번호 목록
     * @return 로또 용지가 가지고 있는 번호 개수
     */
    int howManyContain(List<Integer> nums) {
        int containCount = 0;
        for (int num : nums) {
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

        return Objects.equals(numberList, lotto.numberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberList);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numberList +
                '}';
    }
}