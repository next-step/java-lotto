package study.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAddition {
    private static final String[] DEFAULT_SEPARATOR = {",", ":"};
    public static int splitAndSum(String operandWithSeparator) {
        String separatorRex = generateSeparatorRegExr();
        String[] stringOperands = operandWithSeparator.split(separatorRex);
        List<Operand> operands = new ArrayList<>();
        for(String stringOperand: stringOperands) {
            if(stringOperand.isEmpty()) {
                operands.add(new Operand(0));
            } else {
                operands.add(new Operand(Integer.parseInt(stringOperand)));
            }
        }
        return Addition.sum(operands);
    }

    private static String generateSeparatorRegExr() {
        List<String> separators = new ArrayList();
        separators.addAll(Arrays.asList(DEFAULT_SEPARATOR));
        return String.join("|", DEFAULT_SEPARATOR);
    }
}
