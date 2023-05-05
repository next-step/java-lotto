package step2.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private final PickedLottoNumbers pickedLottoNumbers;
    private Ranking ranking;

    public Lotto(List<Integer> pickedNumbers) {
        this(new PickedLottoNumbers(pickedNumbers));
    }

    public Lotto(PickedLottoNumbers pickedLottoNumbers) {
        this.pickedLottoNumbers = pickedLottoNumbers;
    }

    private Lotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        List<Integer> numbers = lottoNumbers.getRandomLottoNumber();
        this.pickedLottoNumbers = new PickedLottoNumbers(numbers);
    }

    public static Lotto issue() {
        return new Lotto();
    }

    public List<Integer> getDetailNumbers() {
        return this.pickedLottoNumbers.get();
    }

    public void rank(Ranking ranking) {
        this.ranking = ranking;
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

    public boolean isSecond() {
        return this.ranking == Ranking.SECOND;
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

