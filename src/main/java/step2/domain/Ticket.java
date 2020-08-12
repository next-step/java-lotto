package step2.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Lotto Ticket
 */
public class Ticket {

    /**
     * 번호 목록
     */
    private final int[] numbers;

    /**
     * 번호 목록을 반환한다.
     *
     * @return
     */
    public int[] getNumbers() {
        return Arrays.copyOf(numbers, numbers.length);
    }

    /**
     * 생성자를 통해 초기화한다.
     * 번호 목록을 생성한다.
     */
    public Ticket(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * 숫자와 비교하여 일치하는 숫자의 갯수를 반환한다.
     *
     * @param compareObj
     * @return
     */
    public long matchCount(final int compareObj) {
        return Arrays.stream(this.numbers)
                .filter(number -> number == compareObj)
                .count();
    }

    /**
     * 숫자 배열과 비교하여 일치하는 숫자의 갯수를 반환한다.
     *
     * @param compareObj
     * @return
     */
    public long matchCount(final int[] compareObj) {
        return Arrays.stream(this.numbers)
                .boxed()
                .filter(Arrays.stream(compareObj)
                        .boxed()
                        .collect(Collectors.toList())::contains)
                .count();
    }

    /**
     * 당첨 여부를 판별한다.
     * @param compareObj
     * @return
     */
    public boolean checkPrize(final int[] compareObj) {
        return this.matchCount(compareObj) == this.numbers.length;
    }

    /**
     * 보너스 번호 당첨 여부를 판별한다.
     * @param bonusNumber
     * @return
     */
    public boolean checkBonusNumber(final int bonusNumber) {
        return this.matchCount(bonusNumber) > 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.numbers);
    }
}
