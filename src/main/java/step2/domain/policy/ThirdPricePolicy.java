package step2.domain.policy;

public class ThirdPricePolicy implements PricePolicy {

    @Override
    public int price() {
        return 5000;
    }
}
