package lotto.model;

import lotto.service.LottoNumberPicker;

import java.util.List;

public class Lotto {

    private final List<LottoBall> lotto;


    public Lotto(List<LottoBall> lottoNum) {
        if (lottoNum.size() != LottoNumberPicker.LOTTO_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 로또 숫자입니다.");
        }
        this.lotto = lottoNum;
    }

    public List<LottoBall> getLotto() {
        return lotto;
    }

    public Integer getMatchedCount(Lotto target) {
        return Long.valueOf(this.lotto.stream().filter((ball)-> target.lotto.contains(ball)).count()).intValue();
    }

    public void addBonusBall(LottoBall lottoBall) {
        this.lotto.add(lottoBall);
    }
}
