package lottoModel;

import java.util.HashSet;
import java.util.Set;

public class LottoInputValue {
    private String text ;

    public LottoInputValue(String text) {
        this.text = text;
    }

    public Set<Integer> convertLastLottoNumbers() {
        Set<Integer> lastLottoNumbers = new HashSet<>();
        String[] values = splitText(clearValue(this.text));
        int number;
        for (String str : values) {
            number = convertNum(str);
            checkValid(number);
            lastLottoNumbers.add(number);
        }
        checkLottoNumberCount(lastLottoNumbers);
        return lastLottoNumbers;
    }

    private static void checkLottoNumberCount(Set<Integer> lastLottoNumbers) {
        if (lastLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 한개임당 6개 숫자 입니다. 확인후 다시 진행 해주세요");
        }
    }

    private static String clearValue(String text) {
        return text.replaceAll(" ", "");
    }

    private static String[] splitText(String text) {
        return text.split(",");
    }

    private static void checkValid(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 범위에 속한 숫자가 아닙니다.");
        }
    }

    public static int convertNum(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 변환시 오류 발생 하였습니다. 숫자 List에 숫자가 아닌 값이 존재 합니다.");

        }
    }
}
