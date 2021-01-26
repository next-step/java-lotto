package secondplacelotto.model;

import secondplacelotto.exception.IsNotScopeInTheNumberException;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<LottoNumber> numbers = new ArrayList<>();

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

    public MatchingNumbers match(MatchingNumbers matchingNumbers, Lotto winningNumbers, BonusNumber bonusNumber){
        int matchingCount = 0;

        for (LottoNumber lottoNumber : numbers) {
            matchingCount = matchWinningNumber(lottoNumber, winningNumbers, matchingCount);
            bonusNumber.match(lottoNumber);
        }

        ProfitByRank.matchByRank(matchingNumbers, matchingCount, bonusNumber.getBonusStatus());

        return matchingNumbers;
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

    private int matchWinningNumber(LottoNumber lottoNumber, Lotto winningNumbers, int matchingCount){

        for (int i = 0; i < winningNumbers.numbers.size(); i++) {
            matchingCount += matchLottoNumber(lottoNumber, winningNumbers.numbers.get(i));
        }

        return matchingCount;
    }

    private int matchLottoNumber(LottoNumber lottoNumber, LottoNumber winningNumber){
        return lottoNumber.matchNumber(winningNumber);
    }

}
