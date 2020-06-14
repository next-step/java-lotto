package step2.domain;

import static step2.domain.LottoGenerator.LOTTO_FIRST_NUMBER;
import static step2.domain.LottoGenerator.LOTTO_LAST_NUMBER;
import static step2.domain.LottoGenerator.LOTTO_SELECTION_COUNT;
import static step2.view.ErrorMessages.DUPLICATED_LOTTO_NUMBER;
import static step2.view.ErrorMessages.INVALID_LOTTO_NUMBER_RANGE;
import static step2.view.ErrorMessages.INVALID_NUMBERS_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;

public class Lotto {

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validLottoNumber();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean hasNumber(int number) {
        return lottoNumbers.contains(number);
    }

    public void validLottoNumber() throws IllegalArgumentException {
        if (CollectionUtils.size(lottoNumbers) != LOTTO_SELECTION_COUNT) {
            throw new IllegalArgumentException(INVALID_NUMBERS_COUNT);
        }

        Set<Integer> set = new HashSet<>(lottoNumbers);
        if (CollectionUtils.size(set) < CollectionUtils.size(lottoNumbers)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER);
        }

        lottoNumbers.forEach(number -> {
            if (number < LOTTO_FIRST_NUMBER || number > LOTTO_LAST_NUMBER) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
            }
        });

    }

    @Override
    public String toString() {
        return "Lotto{" +
            "lottoNumbers=" + lottoNumbers +
            '}';
    }
}
