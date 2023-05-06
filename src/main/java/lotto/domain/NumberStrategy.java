package lotto.domain;

public interface NumberStrategy {
    int generate(int lowLimit, int highLimit);

    void validateLimit(int lowLimit, int highLimit);
}
