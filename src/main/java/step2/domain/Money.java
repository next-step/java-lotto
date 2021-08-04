package step2.domain;

public interface Money {

    Money minus(Money other);

    Integer amount();

    Money sum(Money cache);


}
