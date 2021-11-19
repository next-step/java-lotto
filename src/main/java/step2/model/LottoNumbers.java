package step2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static final int INITIAL_MATCH_COUNT = 0;
    private static final int SUBLIST_START_INDEX = 0;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final List<LottoNumber> defaultLottoNumbers;

    static {
        defaultLottoNumbers = new ArrayList<>();
        for (int lottoNumber = LOTTO_NUMBER_MIN; lottoNumber <= LOTTO_NUMBER_MAX; lottoNumber++) {
            defaultLottoNumbers.add(new LottoNumber(lottoNumber));
        }
    }

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        Collections.shuffle(defaultLottoNumbers);
        lottoNumbers = defaultLottoNumbers.subList(SUBLIST_START_INDEX, LOTTO_NUMBERS_SIZE);
    }

    //랜덤값 테스트의 편의성을 위한 protected 생성자
    protected LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>();
        for (Integer lottoNumber : lottoNumbers) {
            this.lottoNumbers.add(new LottoNumber(lottoNumber));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getMatchCount(LottoNumbers winnerNumbers) {
        int matchCount = INITIAL_MATCH_COUNT;

        for (LottoNumber lottoNumber : lottoNumbers) {
            matchCount = winnerNumbers.contains(lottoNumber) ? matchCount + 1 : matchCount;
        }
        return matchCount;
    }

    private boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return Arrays.toString(lottoNumbers.toArray());
    }
}
