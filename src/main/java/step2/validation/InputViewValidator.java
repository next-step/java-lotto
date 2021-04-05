package step2.validation;

import step2.util.StringUtil;

import java.util.List;
import java.util.stream.Stream;

public class InputViewValidator {
    private InputViewValidator() {
    }
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;

    public static void prizeCountValidate(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
    }

    public static void winningLottoValidate(String number) {
        List<Integer> list = StringUtil.stringToList(number);
        if(list.size() != 6){
            throw new IllegalArgumentException("로또 번호 갯수가 유효하지 않습니다.");
        }


        Stream<Integer> checkDuplicate = list.stream().distinct();
        if(checkDuplicate.count() != 6){
            throw new IllegalArgumentException("중복된 로또 번호가 존재합니다.");
        }

        for (int i = 0; i < list.size(); i++) {
            validateNumber(list.get(i));
        }

    }

    public static void validateNumber(Integer integer) {
        if(integer < MINIMUM || integer > MAXIMUM){
            throw new IllegalArgumentException(String.format("로또 번호 범위가 유효하지 않습니다.(%d ~ %d)", MINIMUM, MAXIMUM));
        }
    }
}
