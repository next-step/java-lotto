package calculator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static calculator.validation.Validation.checkFourBasicOperation;

public class Operations {
    private final List<String> list;

    public Operations(String[] textArray) {
        this.list = separateOperations(textArray);
    }

    private List<String> separateOperations(String[] textArray) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < textArray.length; i++) {
            addText(textArray[i], i, result);
        }
        return result;
    }

    private static void addText(String text, int i, List<String> result) {
        if (isOdd(i)) result.add(checkFourBasicOperation(text));
    }

    private static boolean isOdd(int i) {
        return i % 2 == 1;
    }

    public String findSign(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

}
