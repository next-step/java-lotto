package lotto;

import java.util.*;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static final List<LottoNumber> lottoNumbers = new ArrayList<>();
    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    private final int value;

    public LottoNumber(int value) {
        this.value = value;
    }

    public static List<LottoNumber> getRandomNumber(int count) {
        List<LottoNumber> tmpLottoNumbers = new ArrayList<>(LottoNumber.lottoNumbers);
        Collections.shuffle(tmpLottoNumbers);

        List<LottoNumber> lottos = tmpLottoNumbers.subList(0, count);
        Collections.sort(lottos);
        return lottos;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(value, o.value);
    }

}
