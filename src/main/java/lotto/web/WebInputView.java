package lotto.web;

import lotto.domain.Lotto;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebInputView {

    public static List<String[]> inputDirectNumbers(String inputNumber, int buyAmount) throws IllegalArgumentException {
        if (StringUtils.isBlank(inputNumber)) {
            return new ArrayList<>();
        }

        String[] lines = inputNumber.split("\r\n");

        List<String[]> directNumbers = new ArrayList<>();

        //구매금액보다 수동입력갯수가 크지 않도록 제한
        for (int i = 0; i < buyAmount / Lotto.LOTTO_PRICE; i++) {
            directNumbers.add(splitLottoNumbers(lines[i]));
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
