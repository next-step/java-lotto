package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private List<Integer> lottoNumbers = new ArrayList<>();

    LottoTicket() {
        List<Integer> numbers = new LottoNumberGenerator().generateLottoNumbers();
        Collections.shuffle(numbers);

        for(int i = 0; i < 6; i++) {
            lottoNumbers.add(numbers.get(i));
        }

        Collections.sort(lottoNumbers);
    }

    LottoTicket(Integer[] lottoArray) {
        lottoNumbers = new ArrayList<>(Arrays.asList(lottoArray));
        Collections.sort(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
