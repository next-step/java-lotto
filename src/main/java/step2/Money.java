package step2;

public interface Money {

    Money minus(Money other);

    int money();

    Money sum(Money cache);


}
