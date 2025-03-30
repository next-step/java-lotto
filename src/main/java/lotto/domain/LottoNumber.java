package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int LOTTO_NUM_MIN = 1;
    public static final int LOTTO_NUM_MAX = 45;

    // 미리 생성된 LottoNumber 객체 풀 (캐싱)
    private static final List<LottoNumber> NUMBER_POOL;

    static {
        // 1~45 범위의 LottoNumber 객체를 미리 생성
        NUMBER_POOL = IntStream.rangeClosed(LOTTO_NUM_MIN, LOTTO_NUM_MAX)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    // 정적 팩토리 메서드: 캐싱된 객체 반환
    public static LottoNumber of(int number) {
        validateNumber(number); // 유효성 검사
        return NUMBER_POOL.get(number - 1); // 캐싱된 객체 반환
    }

    // 유효성 검사: 로또 번호가 범위 내에 있는지 확인
    private static void validateNumber(int number) {
        if (number < LOTTO_NUM_MIN || number > LOTTO_NUM_MAX) {
            throw new IllegalArgumentException(
                    "로또 번호는 " + LOTTO_NUM_MIN + "에서 " + LOTTO_NUM_MAX + " 사이여야 합니다."
            );
        }
    }

    public int getNumber() {
        return number;
    }

    public static List<LottoNumber> getShuffledNumbers() {
        List<LottoNumber> copy = new ArrayList<>(NUMBER_POOL); // 방어적 복사
        Collections.shuffle(copy);
        return copy;
    }
}
