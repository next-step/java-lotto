package stringsumcalculator.model;



import stringsumcalculator.exception.NegativeNumberException;

import java.util.ArrayList;
import java.util.List;

public class Operands {

    private final List<Integer> operands = new ArrayList<>();

    public Operands(String stringOperands, Separators separators) {

        if (stringOperands.contains("-")) {
            throw new NegativeNumberException("음수는 피연산자로 사용할 수 없습니다");
        }

        for (String stringOperand : stringOperands.split(makeStringSeparator(separators))){
            operands.add(Integer.parseInt(stringOperand));
        }

    }

    private String makeStringSeparator(Separators separators) {
        StringBuilder stringSeparators = new StringBuilder(separators.getSeparator(0));

        for (int i = 1; i < separators.getCount(); i++) {
            stringSeparators.append("|").
                    append(StringFilter.filtering(separators.getSeparator(i)));
        }

        return stringSeparators.toString();
    }

    public int getCount(){
        return operands.size();
    }

    public int getOperand(int index) {
        return operands.get(index);
    }
}
