package step2.domain;

public interface Money {

    Money minus(Money other);

    int money();

    Money sum(Money cache);


}
