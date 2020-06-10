package step2.domain;

import static step2.domain.LottoGenerator.LOTTO_SELECTION_COUNT;
import static step2.view.ErrorMessages.INVALID_WINNING_NUMBERS;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

public class Lotto {

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public void validateWinningNumbers() throws IllegalArgumentException {

        if (CollectionUtils.size(lottoNumbers) != LOTTO_SELECTION_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS);
        }
    }

    @Override
    public String toString() {
        return "Lotto{" +
            "lottoNumbers=" + lottoNumbers +
            '}';
    }
}
