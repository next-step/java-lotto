package step2;

import java.util.List;

public class Lotto {
    private static final Money PRICE = Money.of(1000);
    // TODO:: number도 객체화
    private final List<Integer> numbers;
    

    private Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(final CreateLottoNumberStrategy strategy) {
        return new Lotto(strategy.create());
    }
    
    
    public static Money getPrice() {
        return PRICE;
    }
}
