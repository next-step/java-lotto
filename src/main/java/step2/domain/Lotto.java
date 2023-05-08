package step2.domain;

import java.util.List;
import java.util.Objects;

public final class Lotto {

    private final PickedLottoNumbers pickedLottoNumbers;
    private final Ranking ranking;

    private Lotto() {
        List<Integer> numbers = LottoNumbers.getRandomLottoNumber();
        this.pickedLottoNumbers = new PickedLottoNumbers(numbers);
        this.ranking = Ranking.MISSING;
    }

    public Lotto(List<Integer> pickedNumbers) {
        this(new PickedLottoNumbers(pickedNumbers), Ranking.MISSING);
    }

    public Lotto(PickedLottoNumbers pickedLottoNumbers) {
        this(pickedLottoNumbers, Ranking.MISSING);
    }

    public Lotto(List<Integer> numbers, Ranking ranking) {
        this(new PickedLottoNumbers(numbers), ranking);
    }

    public Lotto(PickedLottoNumbers pickedLottoNumbers, Ranking ranking) {
        this.pickedLottoNumbers = pickedLottoNumbers;
        this.ranking = ranking;
    }

    public static Lotto issue() {
        return new Lotto();
    }

    public List<Integer> getDetailNumbers() {
        return this.pickedLottoNumbers.get();
    }

    public int getPrizedMoney() {
        return this.ranking.getWinningMoney();
    }

    public Ranking getRanking() {
        return ranking;
    }

    public int match(WinningNumbers winningNumbers) {
        return this.pickedLottoNumbers.match(winningNumbers);
    }

    public boolean containBonusNumber(int number) {
        return this.pickedLottoNumbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(pickedLottoNumbers, lotto.pickedLottoNumbers)
            && ranking == lotto.ranking;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pickedLottoNumbers, ranking);
    }
}

