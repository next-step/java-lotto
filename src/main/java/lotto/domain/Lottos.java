package lotto.domain;

import java.util.*;

import static lotto.domain.LottoGameOptions.*;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos() {
        this(0);
    }

    public Lottos(int count) {
        while (count-- > 0) {
            buyAuto();
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    public void buyManual(List<String> manualLottoStringList) {
        for (String manualLottoString : manualLottoStringList) {
            lottos.add(new Lotto(manualLottoString));
        }
    }

    public void buyAuto(int countOfAvailableAutoLotto) {
        while (countOfAvailableAutoLotto-- > 0) {
            buyAuto();
        }
    }

    private void buyAuto() {
        lottos.add(new Lotto(generate()));
    }

    private LottoNumbers generate() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

    @Override
    public String toString() {
        return lottos.toString();
    }

    public List<Lotto> values() {
        return this.lottos;
    }
}
