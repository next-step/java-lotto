import number.PositiveInt;
import operator.Operator;

public class StringCalculator {

    public int calculate(String[] tokens) {
        PositiveInt result = PositiveInt.from(tokens[0]);
        for (int i = 1; i < tokens.length - 1; i += 2) {
            result = intermediateCalculate(result, tokens[i], tokens[i + 1]);
        }

        return result.getValue();
    }

    private PositiveInt intermediateCalculate(PositiveInt x, String sign, String number) {
        Operator operator = Operator.findBySign(sign);
        PositiveInt y = PositiveInt.from(number);
        int intermediate = operator.execute(x.getValue(), y.getValue());

        return new PositiveInt(intermediate);
    }
}
