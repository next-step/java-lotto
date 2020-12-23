package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 로또 클래스
 */
public class Lotto {

    public static final int LOTTO_NUMBERS_SIZE = 6;     // 로또 번호 크기
    private final List<LottoNumber> numbers;            // 로또 번호 목록
    private int matchingCount = 0;                      // 매칭된 갯수

    public Lotto(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또의 숫자는 6개입니다.");
        }
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public Lotto(List<LottoNumber> numbers, int matchingCount) {
        this.numbers = numbers;
        this.matchingCount = matchingCount;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    /**
     * 당첨 번호와 자동 생산된 로또 번호 비교하기
     * @param luckyLotto 당첨 로또
     */
    public void draw(Lotto luckyLotto) {
        matchingCount = (int) numbers.stream()
                .filter(luckyLotto::contains)
                .count();
    }

    private boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public String toStringNumbers() {
        return Arrays.toString(numbers.stream()
                .map(LottoNumber::print)
                .toArray(String[]::new));
    }

}
