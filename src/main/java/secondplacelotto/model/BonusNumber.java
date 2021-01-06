package secondplacelotto.model;

import secondplacelotto.exception.IsNotScopeInTheNumberException;

public class BonusNumber {
    
    private final int number;
    private boolean matchingStatus = false;
    
    public BonusNumber(int number){
        if (!(0 < number && number < 46)) {
           throw new IsNotScopeInTheNumberException("보너스번호는 1부터 45까지 가능합니다");
        }

        this.number = number;
    }

    public void match(int lottoNumber, int matchingCount) {
        if (lottoNumber == number && matchingCount == 5) {
            matchingStatus = true;
        }
    }

    public boolean isMatching() {
        return matchingStatus;
    }

    public void refreshMatchingStatus() {
        matchingStatus = false;
    }

}
