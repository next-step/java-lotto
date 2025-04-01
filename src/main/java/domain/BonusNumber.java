package domain;

import java.util.List;

public class BonusNumber {
    private int number;

    public BonusNumber(int number){
        this.number = number;
    }

    public BonusNumber(int number, List<Integer> winningNums){
        this(number);

        if(winningNums.contains(number)){
            throw new IllegalArgumentException("당첨 번호에 보너스 넘버가 포함되어있습니다. number : " + number);
        }
    }

    public boolean isMatch(Lotto lotto){
        return lotto.getNumList()
            .stream().anyMatch(lottoNum -> lottoNum == this.number);
    }
}
