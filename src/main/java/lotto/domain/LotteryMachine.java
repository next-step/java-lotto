package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Lotto.LOTTO_NUMBERS_SIZE;

/**
 * 복권 기계 클래스
 */
public class LotteryMachine {

    private static final long LOTTO_PRICE = 1_000L;
    private static final Integer[] LOTTO_NUMBERS = IntStream.range(1, 46).boxed().toArray(Integer[]::new);

    /**
     * 입력된 금액에 해당하는 로또 발권 갯수를 구한다.
     * @param amount 입력된 금액
     * @return 로또 발권 갯수
     */
    public static int calculateLottoCount(long amount) {
        long lottoCount = amount / LOTTO_PRICE;
        return (int) lottoCount;
    }

    /**
     * 로또 발권 갯수만큼 자동 로또를 발행한다.
     * @param lottoCount 로또 발권 갯수
     * @return 발권된 로또 목록
     */
    public static Lottos issueAutomaticLotto(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto(createLottoNumbers()));
        }
        return new Lottos(lottoList);
    }

    private static List<LottoNumber> createLottoNumbers() {
        return createNumbers().stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static List<Integer> createNumbers() {
        List<Integer> numbers = Arrays.asList(LOTTO_NUMBERS.clone());
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, LOTTO_NUMBERS_SIZE);
        Collections.sort(numbers);
        return numbers;
    }

}