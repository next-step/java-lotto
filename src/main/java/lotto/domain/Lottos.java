package lotto.domain;

import java.util.*;

import static lotto.domain.LottoGameOptions.*;

public class Lottos implements Iterable<Lotto> {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos() {
        this(0);
    }

    public Lottos(int count) {
        while (count-- > 0) {
            buy();
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

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

    @Override
    public String toString() {
        return lottos.toString();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return new Iterator<Lotto>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < lottos.size();
            }

            @Override
            public Lotto next() {
                return lottos.get(index++);
            }
        };
    }

    public List<Lotto> values() {
        return this.lottos;
    }
}
