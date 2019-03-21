package lotto.web;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebInputView {

    public static List<String[]> inputDirectNumbers(String inputNumber) throws IllegalArgumentException {
        String[] lines = inputNumber.split("\r\n");

        List<String[]> directNumbers = new ArrayList<>();
        for (String line : lines) {
            directNumbers.add(splitLottoNumbers(line));
        }

        return directNumbers;
    }

    /**
     * 입력번호 예외 체크
     */
    public static String[] splitLottoNumbers(String inputValue) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^([0-9]+,)+[0-9]+$");
        Matcher matcher = pattern.matcher(inputValue.trim());
        if (!matcher.find()) {
            throw new IllegalArgumentException("패턴 불일치");
        }

        return inputValue.split(",");
    }
}
