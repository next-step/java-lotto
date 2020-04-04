package lotto.Domain;


import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumber;

    private Lotto(List<Integer> lottoNumber) {
        lottoNumberCountException(lottoNumber.size());
        Collections.sort(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static Lotto init(List<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }

    private void lottoNumberCountException(int lottoNumberCount) {
        if(lottoNumberCount != 6) {
            throw new IllegalArgumentException(lottoNumberCount + "개의 로또 번호가 입력되었습니다.");
        }
    }

    public LottoGrade match(WinningLotto winningNumber) {
        int matchCount = winningNumber.matchLotto(Lotto.init(lottoNumber));
        boolean matchBonus = winningNumber.matchBonus(Lotto.init(lottoNumber));
        return LottoGrade.findGrade(matchCount, matchBonus);
    }

    public boolean isNumberMatch(int number) {
        return lottoNumber.contains(number);
    }

    public List<Integer> toList() {
        return Collections.unmodifiableList(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }
}
