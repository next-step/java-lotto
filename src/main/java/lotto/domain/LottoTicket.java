package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private static final int PICKED_NUMBERS_SIZE = 6;
    private static final List<Integer> LOTTO_NUMBERS_RANGE = IntStream.range(1, 46).boxed()
            .collect(Collectors.toCollection(ArrayList::new));
    private final List<Integer> pickedNumbers;

    public LottoTicket() {
        pickedNumbers = pickNumbers();
        sortPickedNumbers();
    }

    public LottoTicket(List<Integer> pickedNumbers) {
        this.pickedNumbers = pickedNumbers;
        sortPickedNumbers();
    }

    public List<Integer> pickNumbers() {
        Collections.shuffle(LOTTO_NUMBERS_RANGE);
        return LOTTO_NUMBERS_RANGE.subList(0, PICKED_NUMBERS_SIZE);
    }

    public List<Integer> getPickedNumbers() {
        return pickedNumbers;
    }

    public void sortPickedNumbers() {
        Collections.sort(pickedNumbers);
    }
}
