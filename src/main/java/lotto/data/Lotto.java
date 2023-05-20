package lotto.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.data.LottoUtil.makeLottoNumberPool;

public class Lotto {
    private List<Integer> numbers;

    public Lotto() {
        this.numbers = makeNumbers();
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public static List<Lotto> getNewLottoList(int amount) {
        List<Lotto> newLottoList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            newLottoList.add(new Lotto());
        }

        return newLottoList;
    }

    public List<Integer> makeNumbers() {
        final int FROM_INDEX = 0;
        final int TO_INDEX = 6;

        final List<Integer> lotteNumbers = makeLottoNumberPool();
        Collections.shuffle(lotteNumbers);

        return lotteNumbers.subList(FROM_INDEX, TO_INDEX);
    }

}
