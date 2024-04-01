package lottery.domain;

import lottery.domain.vo.LottoNumber;
import lottery.util.StringConverter;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final Integer PRICE = 1000;

    public static final Integer NUMBER_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(){
        this(quickPick());
    }

    public LottoTicket(String lottoNumbersString){
        this(manualPick(lottoNumbersString));
    }

    public LottoTicket(Integer[] numbers){
        this(Arrays.stream(numbers)
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
    }

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Set<LottoNumber> lottoNumbers(){
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

    private static Set<LottoNumber> manualPick(String lottoNumbersString){
        validateManualNumbersString(lottoNumbersString);
        Set<Integer> numbers = StringConverter.convertToIntegerSet(lottoNumbersString);
        Set<LottoNumber> manualNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        validateManualNumbersSize(manualNumbers);
        return manualNumbers;
    }

    private static void validateManualNumbersString(String lottoNumbersString){
        if (Objects.isNull(lottoNumbersString) || lottoNumbersString.isBlank())
            throw new IllegalArgumentException("로또 번호는 비어있으면 안됩니다.");
    }

    private static void validateManualNumbersSize(Set<LottoNumber> manualNumbers){
        if (!Objects.equals(manualNumbers.size(), LottoTicket.NUMBER_SIZE))
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다");
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
