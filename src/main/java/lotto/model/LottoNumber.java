package lotto.model;

public class LottoNumber {
    private final int MIN_LOTTO_NUM = 1;
    private final int MAX_LOTTO_NUM = 45;
    private final String OUT_OF_NUMER_RANGE_MESSAGE = "out of number range";
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = validate(lottoNumber);
    }

    private int validate(int number){
        if(number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM){
            throw new RuntimeException(OUT_OF_NUMER_RANGE_MESSAGE);
        }
        return number;
    }
}
