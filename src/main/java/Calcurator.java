import domain.ArithmeticSign;
import domain.Number;

import java.util.List;

public class Calcurator {

    private Arithmetic arithmetic = new Arithmetic();

    public Number calculate(List<String> resource) {
        if (resource.isEmpty() || resource.size() == 0) {
            return new Number(0);
        }
        Number result = new Number(resource.get(0));
        for (int i = 0; i < resource.size() - 2; i += 2) {
            result = arithmetic.doArithmetic(result, new Number(resource.get(i + 2)), new ArithmeticSign(resource.get(i + 1)));
        }
        return result;
    }


}
