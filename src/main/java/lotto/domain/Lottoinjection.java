package lotto.domain;

public class Lottoinjection {

    public static NumbersGenerator provideNumbersGenerator(){
        return new NumbersGenerator();
    }

    public static Lotto provideLotto(){
        return new Lotto(provideNumbersGenerator().getNumbers());
    }
}
