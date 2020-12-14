package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int LOTTO_NUMBERS_SIZE = 46;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = this.createLottoNumbers();
    }

    /**
     * 로또 번호들을 생성합니다.
     * @return
     */
    private List<LottoNumber> createLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumbers.LOTTO_NUMBERS_SIZE);
        for (int i = 1; i <= LottoNumbers.LOTTO_NUMBERS_SIZE; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        return lottoNumbers;
    }

    /**
     * 주어진 크기만큼의 로또 번호를 뽑습니다.
     * @param amount
     * @return
     */
    public List<Integer> pickLottoNumber(int amount) {
        this.shuffleLottoNumbers();
        return this.lottoNumbers.stream().limit(amount)
                                        .sorted()
                                        .map(LottoNumber::getLottoNumber)
                                        .collect(Collectors.toList());
    }

    /**
     * 로또번호를 무작위로 섞습니다.
     */
    private void shuffleLottoNumbers() {
        Collections.shuffle(this.lottoNumbers);
    }
}
