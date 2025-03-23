package lotto.model.generator;

public class NumberGeneratorTestImpl implements NumberGenerator {

    private int number = 1;

    @Override
    public int generate(int maxNumber) {
        return number++;
    }

}
