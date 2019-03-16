package calculator.view;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorView {

    public static String getInputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String[] splitInputValue(String inputValue, String separator) {
        if (separator.isEmpty()) {
            return inputValue.split("[,:]");
        }

        return inputValue.substring(5).split(separator);
    }

    public static void isBlankOrNull(String inputValue) throws IllegalArgumentException {
        if (StringUtils.isEmpty(inputValue)) {
            throw new IllegalArgumentException("입력값이 없음");
        }
    }

    public static String checkCustomSeparator(String inputValue) {
        Pattern pattern = Pattern.compile("//.\n*");
        Matcher matcher = pattern.matcher(inputValue);

        if (matcher.find()) {
            return inputValue.substring(2, 3);
        }

        return "";
    }
}
