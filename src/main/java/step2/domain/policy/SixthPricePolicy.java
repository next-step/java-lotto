package step2.domain.policy;

import step2.domain.policy.PricePolicy;

public class SixthPricePolicy implements PricePolicy {

    @Override
    public int price() {
        return 2000000000;
    }
}
