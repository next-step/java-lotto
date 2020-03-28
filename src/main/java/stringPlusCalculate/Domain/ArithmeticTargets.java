package stringPlusCalculate.Domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticTargets {

    List<Double> arithmeticTargets;

    private ArithmeticTargets(List<Double> arithmeticTargets) {
        this.arithmeticTargets = arithmeticTargets;
    }

    public static ArithmeticTargets empty() {
        return new ArithmeticTargets(new ArrayList<>());
    }

    public static ArithmeticTargets createByStringList(List<String> arithmeticTargets) {
        List<Double> castCollect = arithmeticTargets.stream().mapToDouble(Double::parseDouble).boxed().collect(Collectors.toList());
        return new ArithmeticTargets(castCollect);
    }

    public List<Double> toList() {
        return Collections.unmodifiableList(arithmeticTargets);
    }
}
