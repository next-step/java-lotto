package study.step2.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private final static String DUPLICATION_EXCPETION = "로또 번호는 중복될 수 없습니다.";
    private final static String MIN_LOTTO_NUMBERS_EXCPETION = "로또 번호는 최소 6개 입니다.";
    public final static int LOTTO_NUMBERS_COUNT = 6;
    private final List<Integer> numbers;

    public LottoTicket(LottoNumberGenerator numberGenerator) {
        this(numberGenerator.getLottoNumbers());
    }

    private LottoTicket(List<Integer> numbers){
        validateNumbersCount(numbers);
        validateNumbersDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersDuplication(List<Integer> numbers) {
        Set<Integer> numbersSet = numbers.stream()
                                         .collect(Collectors.toSet());

        if (numbersSet.size() != LOTTO_NUMBERS_COUNT ){
            throw new IllegalArgumentException(DUPLICATION_EXCPETION);
        }
    }

    private void validateNumbersCount(List<Integer> numbers) {
       if (numbers.size() != LOTTO_NUMBERS_COUNT){
           throw new IllegalArgumentException(MIN_LOTTO_NUMBERS_EXCPETION);
       }
    }

    public int countWinningNumbers(List<Integer> winningNumbers){
        return numbers.stream()
                .filter(number -> winningNumbers.contains(number))
                .collect(Collectors.toList())
                .size();
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
