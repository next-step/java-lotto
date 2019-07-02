package camp.nextstep.edu.lotto.domain;

@FunctionalInterface
public interface BonusResolver {
    boolean supports(boolean bonus);
}
