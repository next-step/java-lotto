/*
 * 로또 한장과, 로또의 묶음단위, 당첨 도메인들의 생성을 담당하는 팩토리 클래스
 * */
package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    private static LottoStrategy lottoStrategy;

    public static void setLottoStrategy(LottoStrategy strategy) {
        lottoStrategy = strategy;
    }

    public static Lotto lotto() {
        return new Lotto(lottoStrategy.makeLotto());
    }

    public static Lottos lottos(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(lotto());
        }
        Lottos lottos = new Lottos(lottoList);
        return lottos;
    }

    public static Winning winning(List<LottoNumber> winningNumber) {
        return new Winning(winningNumber);
    }
}
