package lotto.domain;

import lotto.exception.IllegalLottoNumberCountException;
import lotto.util.LottoNumber;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {

    private final List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers of(String separateNumber) {
        SeparateNumber number = SeparateNumber.of(separateNumber);
        return new LottoNumbers(number.initLottoNumbers());
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int match(LottoNumbers lottoTickets) {
        List<Integer> buyTicket = lottoTickets.getLottoNumbers();
        return (int) buyTicket.stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        int size = nonDuplicateNumbers.size();
        if (size != LottoNumber.LOTTO_NUMBER_SIZE) {
            throw new IllegalLottoNumberCountException(size);
        }
    }
}
