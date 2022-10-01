package lotto.model;

import lotto.service.LottoNumberPicker;

import java.util.List;

public class Lotto {

    private final List<LottoBall> lotto;


    public Lotto(List<LottoBall> lottoNum) {
        if (lottoNum.size() < LottoNumberPicker.LOTTO_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 로또 숫자입니다.");
        }
        this.lotto = lottoNum;
    }

    public List<LottoBall> getLotto() {
        return lotto;
    }

    public int getMatchCount(WinningLotto target) {
        return Long.valueOf(this.lotto.stream().filter(target::hasLottoBall).count()).intValue();
    }

    public int size() {
        return this.lotto.size();
    }

    public boolean hasLottoBall(LottoBall lottoBall) {
        return this.lotto.contains(lottoBall);
    }

}
