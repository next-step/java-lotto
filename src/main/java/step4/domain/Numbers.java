package step4.domain;

import step4.util.StringUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

public class Numbers {

    private static final int LOTTO_LIMIT_NUMBER = 6;
    private static final String LOTTO_SPLIT_COMMA = ",";

    private String lottoNumber;

    private Numbers(String lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static Numbers of(String lottoNumber) {
        validate(lottoNumber);
        return new Numbers(lottoNumber);
    }

    public String getLottoNumber() {
        return this.lottoNumber;
    }

    private static void isEmpty(String lottoNumber) {
        if (StringUtil.isEmpty(lottoNumber)) {
            throw new IllegalArgumentException("로또 번호를 입력해 주세요.");
        }
    }

    private static void lottoNumberSizeValidate(String lottoNumber) {
        String[] lottoNumbers = lottoNumber.split(LOTTO_SPLIT_COMMA);
        if (lottoNumbers.length != LOTTO_LIMIT_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 6보다 작거나 클 수 없습니다.");
        }
    }

    private static void numberValidate(String lottoNumber) {
        Pattern positivePattern = Pattern.compile("-(?:[0-9])");
        Pattern negativePattern = Pattern.compile("([0-9])");

        if (positivePattern.matcher(lottoNumber).find()) {
            throw new IllegalArgumentException("양수인 숫자만 입력 가능합니다.");
        }

        if (!negativePattern.matcher(lottoNumber).find()) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static void duplicate(String lottoNumber) {
        String[] lottoNumbers = lottoNumber.split(LOTTO_SPLIT_COMMA);
        lottoNumbers = new HashSet<>(Arrays.asList(lottoNumbers)).toArray(new String[0]);
        if (lottoNumbers.length < 6) {
            throw new IllegalArgumentException("로또 번호는 중복 될 수 없습니다.");
        }
    }

    private static void validate(String lottoNumber) {
        isEmpty(lottoNumber);
        lottoNumberSizeValidate(lottoNumber);
        numberValidate(lottoNumber);
        duplicate(lottoNumber);
    }
}
