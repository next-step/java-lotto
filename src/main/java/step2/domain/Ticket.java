package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Lotto Ticket
 */
public class Ticket {
    private static final Random DICE = new Random();

    /**
     * 번호 갯수
     */
    private static final int NUMBER_COUNT = 6;

    /**
     * 무작위로 정의되는 번호의 범위
     */
    private static final int NUMBER_BOUNDARY = 45;

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
        return Arrays.copyOf(numbers, NUMBER_COUNT);
    }

    /**
     * 생성자를 통해 초기화한다.
     * 번호 목록을 생성한다.
     */
    public Ticket() {
        this.numbers = createNumbers();
    }

    /**
     * 번호 목록을 생성하여 반환한다.
     *
     * @return
     */
    private static final int[] createNumbers() {
        List<Integer> result = new ArrayList<>();

        while (result.size() < NUMBER_COUNT) {
            result.add(nextNumber(result));
        }

        // 생성된 번호 목록을 섞는다.
        Collections.shuffle(result);

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    /**
     * numbers 목록을 기준으로 중복되지 않는 숫자를 반환한다.
     * 숫자는 nextInt() 함수를 통해 생성한다. (숫자 범위 1 ~ 45)
     *
     * @param numbers
     * @return
     */
    private static final int nextNumber(final List<Integer> numbers) {
        int result = nextInt(NUMBER_BOUNDARY);
        boolean duplicated = checkDuplicate(numbers, result);

        while (duplicated) {
            result = nextInt(NUMBER_BOUNDARY);
            duplicated = checkDuplicate(numbers, result);
        }

        return result;
    }

    /**
     * 숫자를 반환한다.
     * 숫자 범위 1 ~ 45
     *
     * @param bound
     * @return
     */
    private static final int nextInt(final int bound) {
        return DICE.nextInt(bound) + 1;
    }

    /**
     * 숫자 목록과 숫자를 비교하여 중복된 숫자 여부를 판별한다.
     *
     * @param numbers
     * @param number
     * @return
     */
    private static final boolean checkDuplicate(final List<Integer> numbers, final int number) {
        return numbers.stream()
                .filter(value -> value == number)
                .findFirst()
                .isPresent();
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
                .filter(Arrays.stream(compareObj).boxed().collect(Collectors.toList())::contains)
                .count();
    }

    /**
     * 당첨금을 반환한다.
     *
     * @param winningNumber
     * @return
     */
    public int prizeMoney(final int[] winningNumber) {
        final long matchCount = matchCount(winningNumber);

        LottoRanking lottoRanking = Arrays.stream(LottoRanking.values())
                .filter(ranking -> ranking.getMatchCount() == matchCount)
                .findFirst()
                .orElse(null);

        if (lottoRanking == null)
            return 0;

        return lottoRanking.getPrizeMoney();
    }

    @Override
    public String toString() {
        return Arrays.toString(this.numbers);
    }
}
