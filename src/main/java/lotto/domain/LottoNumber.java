package lotto.domain;

import lotto.exception.LottoNumberException;

public class LottoNumber {

    private static final String ERR_MESSAGE_RANGE = "로또 숫자 범위를 확인해주세요 (입력범위 1 ~ 45)";
    private static final int END_NUMBER = 45;
    private static final int START_NUMBER = 1;
    private final int lottoNumber;

    public LottoNumber(String lottoNumber) {
        try {
            this.lottoNumber = Integer.parseInt(lottoNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(Lottos.ERR_MESSAGE_NUMBER_FORMAT);
        }
    }

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static void valid(int number) {
        if (number < START_NUMBER || number > END_NUMBER) {
            throw new LottoNumberException(ERR_MESSAGE_RANGE);
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
