package lotto.model;


import lotto.service.LottoNumberPicker;

public class LottoBall {

    private final int num;
    public LottoBall(int num) {
        if (validateLottoNumber(num)){
            throw new IllegalArgumentException("유효하지 않은 로또 번호입니다.");
        }
        this.num = num;
    }

    private boolean validateLottoNumber(int num) {
        return num < 0 || num >= LottoNumberPicker.MAX_BOUND_NUM;
    }
}