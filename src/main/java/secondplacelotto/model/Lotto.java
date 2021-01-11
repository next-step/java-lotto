package secondplacelotto.model;

import secondplacelotto.exception.IsNotScopeInTheNumberException;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<LottoNumber> numbers = new ArrayList<>();
    private int matchingCount;

    public Lotto(){
        numbers = NumbersGenerator.generateLottoNumbers();
    }

    public Lotto(String[] stringWinningNumbers){
        for (String stringWinningNumber : stringWinningNumbers) {
            numbers.add(new LottoNumber(parseInt(stringWinningNumber)));
        }
    }

    private int parseInt(String stringWinningNumber) {
        return Integer.parseInt(stringWinningNumber);
    }

    public void match(Lotto winningNumbers, BonusNumber bonusNumber){
        for(LottoNumber lottoNumber : numbers) {
            matchWinningNumber(lottoNumber, winningNumbers, bonusNumber);
        }

        MatchingNumbers.addMatchingCount(Integer.toString(matchingCount), bonusNumber);

        matchingCount = 0;
    }

    public String makeViewNumbers() {
        StringBuilder stringNumbers = new StringBuilder();

        stringNumbers.append("[");
        stringNumbers.append(numbers.get(0).viewNumber());

        for (int i = 1; i < numbers.size(); i++) {
            stringNumbers.append(", ").append(numbers.get(i).viewNumber());
        }

        stringNumbers.append("]");
        return stringNumbers.toString();
    }

    private void matchWinningNumber(LottoNumber lottoNumber, Lotto winningNumbers, BonusNumber bonusNumber){

        for (int i = 0; i < winningNumbers.numbers.size(); i++) {
            matchLottoNumber(lottoNumber, winningNumbers.numbers.get(i));
        }

        bonusNumber.match(lottoNumber, matchingCount);
    }

    private void matchLottoNumber(LottoNumber lottoNumber, LottoNumber winningNumber){
        matchingCount += lottoNumber.matchNumber(winningNumber);
    }

}
