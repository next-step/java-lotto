package secondplacelotto.model;

import secondplacelotto.exception.IsNotScopeInTheNumberException;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<Integer> numbers = new ArrayList<>();
    private int matchingCount;

    public Lotto(){
        numbers = NumbersGenerator.generateLottoNumbers();
    }

    public Lotto(String[] stringWinningNumbers){
        for (String stringWinningNumber : stringWinningNumbers) {
            numbers.add(parseInt(stringWinningNumber));
        }
    }

    private int parseInt(String stringWinningNumber) {
        int winningNumber = Integer.parseInt(stringWinningNumber);

        if (!(1 <= winningNumber && winningNumber <= 45)) {
            throw new IsNotScopeInTheNumberException("로또 번호는 1부터 45까지의 숫자만 가능합니다");
        }

        return winningNumber;
    }

    public void match(Lotto winningNumbers, BonusNumber bonusNumber){
        for(int lottoNumber : numbers) {
            matchWinningNumber(lottoNumber, winningNumbers, bonusNumber);
        }

        MatchingNumbers.addMatchingCount(Integer.toString(matchingCount), bonusNumber);

        matchingCount = 0;
    }

    public List<Integer> getNumberList() {
        return numbers;
    }

    private void matchWinningNumber(int lottoNumber, Lotto winningNumbers, BonusNumber bonusNumber){

        for (int i = 0; i < winningNumbers.numbers.size(); i++) {
            matchLottoNumber(lottoNumber, winningNumbers.numbers.get(i));
        }

        bonusNumber.match(lottoNumber, matchingCount);
    }

    private void matchLottoNumber(int lottoNumber, int winningNumber){

        if (lottoNumber == winningNumber) {
            matchingCount++;
        }
    }

}
