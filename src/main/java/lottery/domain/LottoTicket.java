package lottery.domain;

import lottery.domain.vo.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final Integer PRICE = 1000;

    public static final Integer NUMBER_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(){
        this(quickPick());
    }

    public LottoTicket(Integer[] numbers){
        this(Arrays.stream(numbers)
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
    }

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Set<LottoNumber> lotteryNumbers(){
        return Collections.unmodifiableSet(lottoNumbers);
    }

    public Long matchNumbersCount(Set<LottoNumber> otherNumbers){
        return lottoNumbers.stream()
                .filter(otherNumbers::contains)
                .count();
    }

    public Boolean matchNumber(LottoNumber otherNumber){
        return lottoNumbers.contains(otherNumber);
    }

    private static Set<LottoNumber> quickPick(){
        Collections.shuffle(LottoNumber.ALL_NUMBERS);
        List<Integer> numbers = LottoNumber.ALL_NUMBERS.subList(0, LottoTicket.NUMBER_SIZE);
        Collections.sort(numbers);
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket lottoTicket = (LottoTicket) o;
        return Objects.equals(lottoNumbers, lottoTicket.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
