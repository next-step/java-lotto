package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator implements Operation{

    ADD("+"){
        @Override
        public int calculator(int num1, int num2) {
            return num1 + num2;
        }
    },
    SUBTRACT("-"){
        @Override
        public int calculator(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTIPLY("*"){
        @Override
        public int calculator(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIVIDE("/"){
        @Override
        public int calculator(int num1, int num2) {
            return num1 / num2;
        }
    };

    private final String operator;
    private static int number = 0;

    Operator(String operator) {
        this.operator = operator;
    }

    public abstract int calculator(int x, int y);


    public static Operator valueOfLabel(String label) {
        return Arrays.stream(Operator.values())
                .filter(oper -> oper.operator.equals(label))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static int calc(List<String> list){
        number = 0;
        for(int i=0; i< list.size(); i++){
            checkOperator(list, i);
        }
        return number;
    }

    private static void checkOperator(List<String> list, int i) {
        if(i%2 != 0){
            number = getNumber(list, number, i);
        }
    }

    private static int getNumber(List<String> list, int number, int i) {
        if(number == 0 && i == 1) {
            return Operator.valueOfLabel(list.get(i)).calculator(Integer.parseInt(list.get(i - 1)), Integer.parseInt(list.get(i + 1)));
        }
        return Operator.valueOfLabel(list.get(i)).calculator(number, Integer.parseInt(list.get(i + 1)));
    }
}
