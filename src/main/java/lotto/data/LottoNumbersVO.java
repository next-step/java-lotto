package lotto.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.util.ConstUtils.*;

public class LottoNumbersVO {

    private final List<Integer> lottoNumbers;

    public LottoNumbersVO() {
        lottoNumbers = createLottoBalls();
    }

    public LottoNumbersVO(List<Integer> manualNumbers) {
        manualNumbers.forEach(this::validateLottoNumberRange);

        this.lottoNumbers = manualNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return List.copyOf(lottoNumbers);
    }

    public int positionValue(int position) {
        return this.lottoNumbers.get(position);
    }

    public boolean isContain(int number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }

    private List<Integer> createLottoBalls() {
        List<Integer> lottoBalls = new ArrayList<>();

        for (int i = MINIMUM_LOTTO_RANGE; i <= MAXIMUM_LOTTO_RANGE; i++) {
            lottoBalls.add(i);
        }

        Collections.shuffle(lottoBalls);
        List<Integer> randomLotto = lottoBalls.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(randomLotto);

        randomLotto.forEach(this::validateLottoNumberRange);

        return randomLotto;
    }

    private void validateLottoNumberRange(int number) {
        if (number < MINIMUM_LOTTO_RANGE || number > MAXIMUM_LOTTO_RANGE) {
            throw new IllegalArgumentException("유효한 로또 번호가 아닙니다. 1~45 숫자중 입력 해 주세요.");
        }
    }
}
