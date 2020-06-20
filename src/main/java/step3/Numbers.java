package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Integer> numbers = new ArrayList<>();

    public Numbers() {
        for (int i = 1 ; i <= 45 ; i++) {
            numbers.add(i);
        }
    }

    public List<LottoNumber> extractLottoNumber() {
        Collections.shuffle(numbers);
        List<LottoNumber> myLottoTicketNumbers = this.extract6Numbers();
        myLottoTicketNumbers.sort(Comparator.comparingInt(LottoNumber::getNumber));

        return myLottoTicketNumbers;
    }

    private List<LottoNumber> extract6Numbers() {
        return Numbers.numbers.stream()
                .map(number -> new LottoNumber(new Integer(number)))
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());
    }
}
