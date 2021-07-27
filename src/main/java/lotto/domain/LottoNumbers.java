package lotto.domain;

import lotto.exception.IllegalLottoNumberCountException;
import lotto.exception.IllegalSeparateException;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        separateValidate(separateNumber);
        String[] split = SEPARATE_PATTERN.split(separateNumber);
        List<Integer> list = Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new LottoNumbers(list);
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

    private static Set<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        Set<LottoNumber> result = new TreeSet<>();
        numbers.forEach(s -> result.add(new LottoNumber(s)));

        return result;
    }

    private void lottoNumberCountValidate(Set<LottoNumber> numbers) {
        int size = numbers.size();
        if (size != LottoNumber.LOTTO_NUMBER_SIZE) {
            throw new IllegalLottoNumberCountException(size);
        }
    }

    private static void separateValidate(String separateNumber) {
        if(!SEPARATE_PATTERN.matcher(separateNumber).find()){
            throw new IllegalSeparateException();
        }
    }
}
