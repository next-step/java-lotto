package step2.domain.policy;

public class ForthPricePolicy implements PricePolicy {

    @Override
    public int price() {
        return 50000;
    }
}
