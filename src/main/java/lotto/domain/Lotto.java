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

    public Lotto(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또의 숫자는 6개입니다.");
        }
        this.numbers = Collections.unmodifiableList(numbers);
    }

    /**
     * 당첨 번호와 로또 번호 비교하기
     * @param luckyLotto 당첨 로또
     * @return 매칭된 갯수
     */
    public int draw(Lotto luckyLotto) {
        return (int) numbers.stream()
                .filter(luckyLotto::contains)
                .count();
    }

    /**
     * 보너스 번호와 로또 번호 비교하기
     * @param matchingCount 매칭된 갯수
     * @param bonusNumber 보너스 번호
     * @return true면 2등(5개 일치하면서 보너스 번호와 일치), false면 아님
     */
    public boolean drawBonus(int matchingCount, LottoNumber bonusNumber) {
        return matchingCount == (LOTTO_NUMBERS_SIZE - 1) && numbers.contains(bonusNumber);
    }

    /**
     * 파라미터의 숫자를 포함하는지 여부 판단
     * @param number 입력 숫자
     * @return 포함 여부 (true: 포함, false: 미포함)
     */
    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    /**
     * 출력용
     * @return  출력 문자열
     */
    public String toStringNumbers() {
        return Arrays.toString(numbers.stream()
                .map(LottoNumber::toStringNumber)
                .toArray(String[]::new));
    }

}