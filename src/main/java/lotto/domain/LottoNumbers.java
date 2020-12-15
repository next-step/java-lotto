package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int DEFAULT_PICK_NUMBER_SIZE = 6;
    public static final int LOTTO_MIN_VALUE = 1;
    public static final int LOTTO_MAX_VALUE = 45;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this(LottoNumbers.DEFAULT_PICK_NUMBER_SIZE);
    }

    public LottoNumbers(int lottoSize) {
        this.createLottoNumbers();
        this.lottoNumbers = this.pickLottoNumber(lottoSize);
    }

    public LottoNumbers(List<Integer> numbers) {
        this.lottoNumbers = numbers.stream().map(LottoNumber::new)
                                            .collect(Collectors.toList());
    }

    /**
     * 무작위로 뽑을 로또 번호 목록들을 생성합니다.
     * @return
     */
    private List<LottoNumber> createLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumbers.LOTTO_MAX_VALUE);
        for (int i = 1; i <= LottoNumbers.LOTTO_MAX_VALUE; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        return lottoNumbers;
    }

    /**
     * 기본값으로 설정된 크기만큼의 로또 번호를 뽑습니다.
     * @return
     */
    private List<LottoNumber> pickLottoNumber() {
        return this.pickLottoNumber(DEFAULT_PICK_NUMBER_SIZE);
    }

    /**
     * 주어진 크기만큼의 로또 번호를 뽑습니다.
     * @param amount
     * @return
     */
    private List<LottoNumber> pickLottoNumber(int amount) {
        List<LottoNumber> lottoNumbers = this.createLottoNumbers();
        this.shuffleLottoNumbers(lottoNumbers);
        return lottoNumbers.stream().limit(amount)
                                        .sorted()
                                        .collect(Collectors.toList());
    }

    /**
     * 로또번호를 무작위로 섞습니다.
     */
    private void shuffleLottoNumbers(List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
    }

    /**
     * 두 로또번호를 비교하여 일치하는 번호의 개수를 반환합니다.
     * @param comparedLottoNumbers
     * @return
     */
    public int matchedLottoNumbersCount(LottoNumbers comparedLottoNumbers) {
        return (int) this.lottoNumbers.stream()
                            .filter(lottoNumber -> comparedLottoNumbers.containsLottoNumber(lottoNumber))
                            .count();
    }

    /**
     * 주어진 로또번호가 로또번호 목록에 있는지 확인
     * @param lottoNumber 
     * @return
     */
    boolean containsLottoNumber(LottoNumber lottoNumber) {
        return this.lottoNumbers.stream().filter(thisLottoNumber -> thisLottoNumber.equals(lottoNumber))
                                    .count() == 1;
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList())
                .toString();
    }
}
