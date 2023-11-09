package calculator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static calculator.validation.Validation.checkNumber;

public class NumberList {
    private final List<Integer> list;
    public NumberList(String[] textArray) {
        this.list = separateNumber(textArray);
    }

    private List<Integer> separateNumber(String[] textArray) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < textArray.length; i++) {
            addNumber(textArray[i], i, result);
        }
        return result;
    }

    private static void addNumber(String text, int i, List<Integer> result) {
        if(isEven(i)) result.add(checkNumber(text));
    }

    private static boolean isEven(int i) {
        return i % 2 == 0;
    }

    public List<Integer> getNumberList(){
        return Collections.unmodifiableList(list);
    }


}
