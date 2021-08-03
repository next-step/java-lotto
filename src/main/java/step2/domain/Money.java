package step2.domain;

public interface Money {

    Money minus(Money other);

    int amount();

    Money sum(Money cache);


}
