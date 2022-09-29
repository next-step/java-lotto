package lotto.model;

import lotto.service.LottoNumberPicker;

import java.util.List;
import java.util.stream.Collectors;

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

    public Lotto getDifference(Lotto target) {
        return new Lotto(this.lotto.stream().filter(target.lotto::contains).collect(Collectors.toList()));
    }

    public void addBonusBall(LottoBall lottoBall) {
        this.lotto.add(lottoBall);
    }

    public int size(){
        return this.lotto.size();
    }

    public boolean hasBonusBall() {
        return this.lotto.stream().anyMatch(LottoBall::isBonusBall);
    }
}
