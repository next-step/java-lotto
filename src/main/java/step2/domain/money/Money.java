package step2.domain.money;

public interface Money {

    Money minus(Money other);

    Integer amount();

    Money sum(Money cache);


}
