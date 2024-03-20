package lotto.domain;

public class Cash {

    public int payLotto(int money){
        if(money < 1000) throw new IllegalArgumentException();
        return money/1000;
    }
}
