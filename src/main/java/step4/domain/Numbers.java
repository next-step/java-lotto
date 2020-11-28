package step4.domain;

import step4.util.StringUtil;

import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Numbers implements Comparable<Numbers> {
    public static final int START_NUM = 1;
    public static final int END_NUM = 45;
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

    private static void numberLimitValidate(String lottoNumber) {
        String[] lottoNumbers = lottoNumber.split(LOTTO_SPLIT_COMMA);
        IntStream.range(0, lottoNumbers.length)
                .filter(i -> Integer.parseInt(lottoNumbers[i]) < START_NUM || Integer.parseInt(lottoNumbers[i]) > END_NUM)
                .forEach(i -> {
                    throw new IllegalArgumentException("로또 번호는 1 ~ 45사이의 숫자여야 합니다.");
                });
    }

    private static void isEmpty(String lottoNumber) {
        if (StringUtil.isEmpty(lottoNumber)) {
            throw new IllegalArgumentException("로또 번호를 입력해 주세요.");
        }
    }

    private static void validate(String lottoNumber) {
        isEmpty(lottoNumber);
        numberLimitValidate(lottoNumber);
    }

    @Override
    public int compareTo(Numbers o) {
        return Integer.compare(Integer.parseInt(lottoNumber), Integer.parseInt(o.getLottoNumber()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers number1 = (Numbers) o;
        return lottoNumber.equals(number1.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

}
