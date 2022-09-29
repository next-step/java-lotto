package lotto.model;


import lotto.service.LottoNumberPicker;

import java.util.Objects;

public class LottoBall {

    private final int num;

    private final boolean isBonusBall;
    private LottoBall(int num , boolean isBonusBall) {
        if (validateLottoNumber(num)){
            throw new IllegalArgumentException("유효하지 않은 로또 번호입니다.");
        }
        this.num = num;
        this.isBonusBall = isBonusBall;
    }

    public int getNum() {
        return num;
    }

    public static LottoBall bonusBall(int num){
        return new LottoBall(num,true);
    }

    public static LottoBall noBonusBall(int num){
        return new LottoBall(num,false);
    }

    private boolean validateLottoNumber(int num) {
        return num < 0 || num >= LottoNumberPicker.MAX_BOUND_NUM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoBall lottoBall = (LottoBall) o;
        return num == lottoBall.num && isBonusBall == lottoBall.isBonusBall;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, isBonusBall);
    }
}