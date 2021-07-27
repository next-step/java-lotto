package lotto.domain;

import lotto.exception.IllegalLottoNumberCountException;
import lotto.exception.IllegalSeparateException;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class LottoNumbers {

    private static final Pattern SEPARATE_PATTERN = Pattern.compile(",");
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this(toLottoNumbers(lottoNumbers));
    }

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        lottoNumberCountValidate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers of(String separateNumber) {
        if(!SEPARATE_PATTERN.matcher(separateNumber).find()){
            throw new IllegalSeparateException();
        }
        return new LottoNumbers(toLottoNumbers(separateNumber));
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    public int match(LottoNumbers lottoTickets) {
        Set<LottoNumber> buyTicket = lottoTickets.getLottoNumbers();
        return (int) buyTicket.stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    private static Set<LottoNumber> toLottoNumbers(String separateStr) {
        String[] split = SEPARATE_PATTERN.split(separateStr);
        Set<LottoNumber> result = new TreeSet<>();
        for (String strNumber : split) {
            result.add(LottoNumber.of(strNumber));
        }

        return result;
    }

    private static Set<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        Set<LottoNumber> result = new TreeSet<>();
        for (Integer number : numbers) {
            result.add(new LottoNumber(number));
        }

        return result;
    }

    private void lottoNumberCountValidate(Set<LottoNumber> numbers) {
        int size = numbers.size();
        if (size != LottoNumber.LOTTO_NUMBER_SIZE) {
            throw new IllegalLottoNumberCountException(size);
        }
    }
}
