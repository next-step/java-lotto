package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumber implements Comparable<LottoNumber>{
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final Map<Integer ,LottoNumber> LOTTO_NUM_CACHE = new HashMap<>();

    static {
        for (int i = 1; i <= 45; i++) {
            LOTTO_NUM_CACHE.put(i, new LottoNumber(i));
        }
    }

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber valueOf(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 적어도" + MIN_LOTTO_NUMBER + "이상이어야 합니다.");
        }

        if (lottoNumber > MAX_LOTTO_NUMBER ) {
            throw new IllegalArgumentException("로또 번호는 최대" + MAX_LOTTO_NUMBER + "초과해서는 안됩니다.");
        }

        return LOTTO_NUM_CACHE.get(lottoNumber);
    }

    public int getLottoNumber() {
        return lottoNumber;
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
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.lottoNumber, other.lottoNumber);
    }

    public static List<LottoNumber> getRandomLottoNumber() {
        List<LottoNumber> lottoNumbers = LOTTO_NUM_CACHE.values().stream().collect(Collectors.toList());

        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, 6);
    }

}
