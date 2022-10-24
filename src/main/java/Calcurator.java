import domain.ArithmeticSign;
import domain.Number;

import java.util.List;

public class Calcurator {

    public Number calculate(List<String> resource) {
        if (resource.isEmpty() || resource.size() == 0) {
            return new Number(0);
        }

        Number result = new Number(resource.get(0));
        for (int i = 0; i < resource.size() - 2; i += 2) {
            ArithmeticSign arithmeticSign = ArithmeticSign.of(resource.get(i + 1));
            arithmeticSign.doArithmetic(result, new Number(resource.get(i + 2)));
        }
        return result;
    }
}
