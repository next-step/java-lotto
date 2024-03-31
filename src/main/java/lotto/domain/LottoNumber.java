package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

    private final Integer number;
    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS;

    public static final int LOTTO_START_INDEX = 1;
    public static final int LOTTO_END_INDEX = 45;

    static {
        LOTTO_NUMBERS = IntStream.range(LOTTO_START_INDEX, LOTTO_END_INDEX)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toMap(LottoNumber::getNumber, lottoNumber -> lottoNumber));
    }

    private LottoNumber(int number) {
        this.number  = number;
    }

    public static LottoNumber of(int number){
        if(number < LOTTO_START_INDEX || number > LOTTO_END_INDEX){
            throw new IllegalArgumentException(String.format("Lotto 의 범위를 벗어났습니다 : %d",number));
        }
        return LOTTO_NUMBERS.get(number);
    }

    public Integer getNumber(){
        return this.number;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number,other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
