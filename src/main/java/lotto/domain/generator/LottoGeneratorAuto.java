package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import static lotto.domain.LottoGameOptions.*;

public class LottoGeneratorAuto implements LottoGenerator{
    private int countOfAvailableAutoLotto;

    public LottoGeneratorAuto(int countOfAvailableAutoLotto) {
        this.countOfAvailableAutoLotto = countOfAvailableAutoLotto;
    }

    @Override
    public Lottos generate() {
        List<Lotto> lottos = new ArrayList<>();

        while (countOfAvailableAutoLotto-- > 0) {
            lottos.add(new Lotto(makeNumbers()));
        }

        return new Lottos(lottos);
    }

    private LottoNumbers makeNumbers() {
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
