package step2.functional;

@FunctionalInterface
public interface PrizeAmount {
    long getPrizeAmount(Integer numOfWinner);
}
