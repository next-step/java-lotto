package lotto.model.generator;

@FunctionalInterface
public interface NumberGenerator {

    int generate(int maxNumber);
}
