package study.step2;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

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

        if (numbersSet.size() != 6 ){
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateNumbersCount(List<Integer> numbers) {
       if (numbers.size() != 6){
           throw new IllegalArgumentException("로또 번호는 최소 6개 입니다.");
       }
    }

    public static void publish(){

    }
}
