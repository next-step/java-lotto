package lotto.domain;

public class injection {

    public static NumbersGenerator provideNumbersGenerator(){
        return new NumbersGenerator();
    }

    public static Lotto provideLotto(){
        return new Lotto(provideNumbersGenerator().getNumbers());
    }
}
