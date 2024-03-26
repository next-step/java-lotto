package lotto.domain;

@FunctionalInterface
public interface LottoPricingKeyFunction {

    String get(int count, boolean condition);
}
