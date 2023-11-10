package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Classifier {
    public static List<Integer> classifyInteger(String[] inputs) {
        isNullOrBlank(inputs);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < inputs.length; i += 2) {
            InputNumber.isInteger(inputs[i]);
            list.add(Integer.valueOf(inputs[i]));
        }
        return list;
    }

    public static List<String> classifyOperator(String[] inputs) {
        isNullOrBlank(inputs);
        List<String> list = new ArrayList<>();
        for (int i = 1; i < inputs.length; i += 2) {
            list.add(inputs[i]);
        }
        return list;
    }

    private static void isNullOrBlank(String[] inputs) {
        if (inputs.length == 0) {
            throw new IllegalArgumentException("입력 값이 Null이거나 빈 공백");
        }
    }
}
