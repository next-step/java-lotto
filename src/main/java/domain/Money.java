package domain;

import java.util.Objects;

import static utility.UserInput.WON;

public class Money {
    private int money;

    public Money(int input) {
        validateInput(input);
        money = input;
    }

    private void validateInput(int input) {
        if(input <  0 ){
            throw new IllegalArgumentException("ERR");
        }
    }

    Money sum(Money money){
        return new Money(this.money+money.money);
    }

    public int getLottoTries(){
       return money / WON;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
