package step2.domain.policy;

public class FifthPricePolicy implements PricePolicy {

    @Override
    public int price() {
        return 1500000;
    }
}
