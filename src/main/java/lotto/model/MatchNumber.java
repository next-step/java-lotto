package lotto.model;

@FunctionalInterface
public interface MatchNumber {

    boolean isMatch(Integer integer);
}
