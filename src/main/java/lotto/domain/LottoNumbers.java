package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int LOTTO_NUMBERS_DEFAULT_SIZE = 46;
    private static final int DEFAULT_PICK_NUMBER_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = this.createLottoNumbers();
    }

    public LottoNumbers(List<Integer> numbers) {
        this.lottoNumbers = numbers.stream().map(LottoNumber::new)
                                            .collect(Collectors.toList());
    }

    /**
     * 로또 번호들을 생성합니다.
     * @return
     */
    private List<LottoNumber> createLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumbers.LOTTO_NUMBERS_DEFAULT_SIZE);
        for (int i = 1; i <= LottoNumbers.LOTTO_NUMBERS_DEFAULT_SIZE; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        return lottoNumbers;
    }

    /**
     * 기본값으로 설정된 크기만큼의 로또 번호를 뽑습니다.
     * @return
     */
    public List<Integer> pickLottoNumber() {
        return this.pickLottoNumber(DEFAULT_PICK_NUMBER_SIZE);
    }

    /**
     * 주어진 크기만큼의 로또 번호를 뽑습니다.
     * @param amount
     * @return
     */
    public List<Integer> pickLottoNumber(int amount) {
        if(!this.canPickLottoNumberSize(amount)) {
            throw new IllegalArgumentException("뽑으려는 번호의 갯수가 미리 세팅된 로또 번호의 크기보다 큽니다.");
        }
        this.shuffleLottoNumbers();
        return this.lottoNumbers.stream().limit(amount)
                                        .sorted()
                                        .map(LottoNumber::getLottoNumber)
                                        .collect(Collectors.toList());
    }

    /**
     * 주어진 수가 미리 세팅 된 로또 번호들의 크기보다 크거나 같아야합니다.
     * @param amount
     * @return
     */
    private boolean canPickLottoNumberSize(int amount) {
        return amount <= this.lottoNumbers.size();
    }

    /**
     * 로또번호를 무작위로 섞습니다.
     */
    private void shuffleLottoNumbers() {
        Collections.shuffle(this.lottoNumbers);
    }
}
