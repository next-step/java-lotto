package step2.domain;

import java.util.List;

public class Lotto {

    private final PickedLottoNumber pickedLottoNumbers;
    private Ranking ranking;

    public Lotto(List<Integer> pickedNumbers) {
        this.pickedLottoNumbers = new PickedLottoNumber(pickedNumbers);
    }

    private Lotto() {
        TotalNumbers totalNumbers = new TotalNumbers();
        List<Integer> numbers = totalNumbers.getRandomLottoNumber();
        this.pickedLottoNumbers = new PickedLottoNumber(numbers);
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
}

