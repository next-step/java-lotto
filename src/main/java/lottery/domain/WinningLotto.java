package lottery.domain;

import lottery.domain.vo.LottoNumber;
import lottery.util.StringConverter;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {
    public static final Integer NUMBER_SIZE = 6;

    private final Set<LottoNumber> winningNumbers;

    public WinningLotto(Set<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public WinningLotto(String winningNumbersString) {
        this(createWinningLotto(winningNumbersString));
    }

    private static Set<LottoNumber> createWinningLotto(String winningNumbersString){
        validateWinningNumbersString(winningNumbersString);
        Set<Integer> numbers = StringConverter.convertToIntegerSet(winningNumbersString);
        Set<LottoNumber> winningNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        validateWinningLottoNumbersSize(winningNumbers);
        return winningNumbers;
    }

    private static void validateWinningNumbersString(String winningNumbersString){
        if (Objects.isNull(winningNumbersString) || winningNumbersString.isBlank())
            throw new IllegalArgumentException("당첨 번호는 비어있으면 안됩니다.");
    }

    private static void validateWinningLottoNumbersSize(Set<LottoNumber> winningNumbers){
        if (!Objects.equals(winningNumbers.size(), NUMBER_SIZE))
            throw new IllegalArgumentException("당첨 로또 번호는 6개만 가능합니다");
    }


    public Set<LottoNumber> winningLotto(){
        return this.winningNumbers;
    }

}
