package study.ascii92der.lotto.step3;

public class LottoNumber {

    public static final int LOTTO_NUMBER_MINIMUM = 1;
    public static final int LOTTO_NUMBER_MAXIMUM = 45;
    public static final String ERROR_MASSAGE_OUT_OF_RANGE_LOTTO_NUMBER = "out of range Lotto number";
    private final int value;

    public LottoNumber(String valueString) {

        this.value = Integer.parseInt(valueString);

        if (!(value >= LOTTO_NUMBER_MINIMUM && LOTTO_NUMBER_MAXIMUM >= value)) {
            throw new IllegalArgumentException(ERROR_MASSAGE_OUT_OF_RANGE_LOTTO_NUMBER);
        }

    }
}
