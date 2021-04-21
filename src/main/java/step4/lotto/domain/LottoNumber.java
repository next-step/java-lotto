package step4.lotto.domain;

import java.util.*;

public class LottoNumber {
    private static final int LOTTO_NUMBER_RANGE_MAX = 45;
    private static final int LOTTO_NUMBER_RANGE_MIN = 1;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static Map<Integer,LottoNumber> lottoNumbers = new HashMap<>();
    private final int lottoNumber;

    static {
        for(int i =LOTTO_NUMBER_RANGE_MIN; i<=LOTTO_NUMBER_RANGE_MAX; i++){
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(String text) {
        return of(Integer.parseInt(text));
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber =  lottoNumbers.get(number);
        if(lottoNumber == null){
            throw new IllegalArgumentException("로또 번호 범위가 아닙니다");
        }
        return lottoNumber;
    }

    public static Set<LottoNumber> autoNumber() {
        List keys = new ArrayList(lottoNumbers.keySet());
        Collections.shuffle(keys);
        List<LottoNumber> auto = new ArrayList<>();
        for(Object object : keys){
            auto.add(lottoNumbers.get(object));
        }
        return new HashSet<>(auto.subList(0, LOTTO_NUMBER_COUNT));
    }

    public boolean contains(List<Integer> userLotto) {
        return userLotto.contains(lottoNumber);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
