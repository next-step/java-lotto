package caculator.domain;

import caculator.exception.NotFormulaException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Formula {

    private static final String SPLITERATOR = " ";

    public static List<String> strToList(String str) {
        checkBlank(str);
        List<String> list = Arrays.asList(str.split(SPLITERATOR));
        if (checkFormula(list)) {
            return list;
        }
        return null;
    }

    public static void checkBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("공백은 허용되지 않습니다.");
        }
    }

    public static boolean checkFormula(List<String> values) {
        checkValuesLength(values.size());
        for (int i = 0; i < values.size(); i++) {
            checkValues(i, values.get(i));
        }
        return true;
    }

    private static void checkValuesLength(int valuesLength) {
        if (valuesLength % 2 == 0) {
            throw new NotFormulaException();
        }
    }

    private static void checkValues(int i, String value) {
        if (i % 2 == 0 && !StringUtils.isNumeric(value)) {
            throw new NotFormulaException();
        }
        if (i % 2 == 1) {
            checkSign(value);
        }
    }

    private static void checkSign(String value) {
        if (StringUtils.isNumeric(value)) {
            throw new NotFormulaException();
        }
    }
}
