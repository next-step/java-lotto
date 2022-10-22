package caculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInput {

    private static final String SPLITERATOR = " ";
    private static final Scanner sc = new Scanner(System.in);

    public List<String> inputFormula() {
        String str = sc.nextLine();
        return strToList(str);
    }

    public List<String> strToList(String str) {
        checkBlank(str);
        List<String> list = Arrays.asList(str.split(SPLITERATOR));
        if (checkFormula(list)) {
            return list;
        }
        return null;
    }

    public void checkBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("공백은 허용되지 않습니다.");
        }
    }

    public boolean checkFormula(List<String> values) {
        checkValuesLength(values.size());
        for (int i = 0; i < values.size(); i++) {
            checkValues(i, values.get(i));
        }
        return true;
    }

    private void checkValuesLength(int valuesLength) {
        if (valuesLength % 2 == 0) {
            throw new IllegalArgumentException("수식이 맞는지 확인 바랍니다.");
        }
    }

    private static void checkValues(int i, String value) {
        if (i % 2 == 0 && !StringUtils.isNumeric(value)) {
            throw new IllegalArgumentException("수식이 맞는지 확인 바랍니다.");
        }
        if (i % 2 == 1) {
            checkSign(value);
        }
    }

    private static void checkSign(String value) {
        if (StringUtils.isNumeric(value)) {
            throw new IllegalArgumentException("수식이 맞는지 확인 바랍니다.");
        }
        if (!ExpressionType.isSign(value)) {
            throw new IllegalArgumentException("사칙 연산 기호만 입력 가능합니다.");
        }
    }
}
