package step2.validation;

import step2.util.StringUtil;

import java.util.List;

public class InputViewValidator {


    public static void prizeCountValidate(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
    }

    public static void winningLottoValidate(String number) {
        List<Integer> list = StringUtil.stringToList(number);
        if(list.size() != 6){
            throw new IllegalArgumentException("로또 번호 숫자가 유효하지 않습니다.");
        }

        for (int i = 0; i < list.size(); i++) {
            validateNumber(list.get(i));
        }

    }

    public static void validateNumber(Integer integer) {
        if(integer < 1 || integer > 45){
            throw new IllegalArgumentException("로또 번호가 유효하지 않습니다.");
        }
    }
}
