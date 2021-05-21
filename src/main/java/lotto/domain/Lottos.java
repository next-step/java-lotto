package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import static lotto.domain.LottoGameOptions.*;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public int count() {
        return lottos.size();
    }

    public void buy() {
        lottos.add(new Lotto(generateRandomLottoNumbers()));
    }

    private LottoNumbers generateRandomLottoNumbers() {
        Stack<Integer> wholeLottoNumbers = makeWholeLottoNumbers(LOTTO_NUMBERS_FROM, LOTTO_NUMBERS_TO);
        Collections.shuffle(wholeLottoNumbers);

        LottoNumbers lottoNumbers = new LottoNumbers();
        while (lottoNumbers.sizeIsNotSameWith(LOTTO_NUMBER_COUNT)) {
            lottoNumbers.add(wholeLottoNumbers.pop());
        }

        return lottoNumbers;
    }

    private Stack<Integer> makeWholeLottoNumbers(int start, int end) {
        Stack<Integer> numbers = new Stack<>();
        for (int number = start; number <= end; ++number) {
            numbers.push(number);
        }
        return numbers;
    }
}
