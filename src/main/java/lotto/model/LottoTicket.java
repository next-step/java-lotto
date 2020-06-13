package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private static final List<Integer> lottoDrawNumbers = new ArrayList(); //{1, 2, 3, 4};

    public LottoTicket() {
        for(int i = 1; i <= 45; i++) {
            lottoDrawNumbers.add(i);
        }
    }

    public List<Integer> buyTicket() {
        Collections.shuffle(lottoDrawNumbers);
        List<Integer> numbers = new ArrayList<>();

        for(int i = 0; i < 6; i++) {
            numbers.add(lottoDrawNumbers.get(i));
        }

        return numbers;
    }
}
