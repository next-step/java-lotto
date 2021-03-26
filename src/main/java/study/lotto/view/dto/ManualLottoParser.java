package study.lotto.view.dto;

import study.lotto.exception.LottoException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static study.lotto.service.LottoFactory.LOTTO_MAX_SIZE;
import static study.lotto.util.Constants.GUIDE_ERR_LOTTO_SIZE;

public class ManualLottoParser {

    private final List<Set<Integer>> manualNumbers;

    private ManualLottoParser(final List<Set<Integer>> manualNumbers) {
        checkValidation(manualNumbers);
        this.manualNumbers = manualNumbers;
    }

    public static ManualLottoParser of(final List<Set<Integer>> manualNumbers) {
        return new ManualLottoParser(manualNumbers);
    }

    private void checkValidation(final List<Set<Integer>> manualNumbers) {
        manualNumbers.forEach(this::lottoSizeException);
    }

    private void lottoSizeException(final Set<Integer> integers) {
        if(integers.size() != LOTTO_MAX_SIZE) {
            throw new LottoException(GUIDE_ERR_LOTTO_SIZE);
        }
    }

    public List<Set<Integer>> getManualNumbers() {
        return Collections.unmodifiableList(manualNumbers);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof ManualLottoParser)) return false;
        final ManualLottoParser that = (ManualLottoParser) o;
        return Objects.equals(manualNumbers, that.manualNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualNumbers);
    }
}
