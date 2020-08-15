package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Lotto Ticket
 */
public class Ticket {

    /**
     * 번호 목록
     */
    private final LottoNumbers numbers;

    /**
     * 생성자를 통해 초기화한다.
     * 번호 목록을 생성한다.
     */
    public Ticket(final List<Integer> numbers) {
        this.numbers = new LottoNumbers(numbers);
    }

    /**
     * 숫자 목록과 비교하여 일치하는 횟수를 반환한다.
     *
     * @param numbers
     * @return
     */
    public long matchCount(final List<Integer> numbers) {
        return this.numbers.matchCount(numbers);
    }

    /**
     * 당첨 여부를 판별한다.
     *
     * @param numbers
     * @return
     */
    public boolean checkPrize(final List<Integer> numbers) {
        return this.numbers.compare(numbers);
    }

    /**
     * 보너스 번호 당첨 여부를 판별한다.
     *
     * @param bonusNumber
     * @return
     */
    public boolean checkBonusNumber(final int bonusNumber) {
        return this.numbers.matchCount(Arrays.asList(bonusNumber)) > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(numbers, ticket.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
