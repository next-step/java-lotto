package step4.util;

import java.util.Arrays;
import java.util.HashSet;

public class NumbersValidate {
    private static final int LOTTO_LIMIT_NUMBER = 6;
    private static final String LOTTO_SPLIT_COMMA = ",";

    public static void validate(String lottoNumber) {
        lottoNumberSizeValidate(lottoNumber);
        duplicate(lottoNumber);
    }
    private static void lottoNumberSizeValidate(String lottoNumber) {
        String[] lottoNumbers = lottoNumber.split(LOTTO_SPLIT_COMMA);
        if (lottoNumbers.length != LOTTO_LIMIT_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 6보다 작거나 클 수 없습니다.");
        }
    }

    private static void duplicate(String lottoNumber) {
        String[] lottoNumbers = lottoNumber.split(LOTTO_SPLIT_COMMA);
        lottoNumbers = new HashSet<>(Arrays.asList(lottoNumbers)).toArray(new String[0]);
        if (lottoNumbers.length < 6) {
            throw new IllegalArgumentException("로또 번호는 중복 될 수 없습니다.");
        }
    }

}
