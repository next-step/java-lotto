package lotto.domain;

import lotto.utils.LottoValidationUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.utils.CommonConstant.NUMBER_SIX;
import static lotto.utils.CommonConstant.NUMBER_ZERO;
import static lotto.utils.LottoValidationUtils.INVALID_DUPLICATION_NUMBER;
import static lotto.utils.LottoValidationUtils.PRINT_LOTTO_NUMBER;

public class LottoTicket {

    private List<Integer> lottoTicket;

    public LottoTicket(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoTicket = generateLottoTicket(lottoNumberGenerator);
        validateLottoRange(lottoTicket);
        validateLottoSize(lottoTicket);
        LottoNumberDuplication(lottoTicket);
    }

    private List<Integer> generateLottoTicket(LottoNumberGenerator lottoNumberGenerator) {
        return lottoNumberGenerator.getLottoNumbers();
    }

    public void validateLottoRange(List<Integer> lottoTicket) {
        for (int number : lottoTicket) {
            LottoValidationUtils.lottoNumberRangeCheck(number);
        }
    }

    private void validateLottoSize(List<Integer> lottoTicket) {
        if (lottoTicket.size() != NUMBER_SIX) {
            throw new RuntimeException(PRINT_LOTTO_NUMBER);
        }
    }

    public void LottoNumberDuplication(List<Integer> lottoTicket) {
        IntStream.range(NUMBER_ZERO, lottoTicket.size())
                .filter(i -> IntStream.range(NUMBER_ZERO, i)
                        .anyMatch(j -> lottoTicket.get(i).equals(lottoTicket.get(j))))
                .forEach(i -> {
                    throw new IllegalArgumentException(INVALID_DUPLICATION_NUMBER);
                });
    }

    public List<Integer> getLottoTicket() {
        return Collections.unmodifiableList(this.lottoTicket);
    }

    public long size() {
        return lottoTicket.size();
    }

    public Integer getLottoTicketNumber(int index) {
        return lottoTicket.get(index);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoTicket);
    }

}
