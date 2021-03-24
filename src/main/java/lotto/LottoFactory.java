/*
 * 로또 한장과, 로또의 묶음단위, 당첨 도메인들의 생성을 담당하는 팩토리 클래스
 * */
package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    public static Lotto lotto(LottoStrategy lottoStrategy) {
        return new Lotto(lottoStrategy.makeLotto());
    }

    public static Lottos lottos(int lottoCount, LottoStrategy lottoStrategy) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(lotto(lottoStrategy));
        }
        return new Lottos(lottoList);
    }

    public static Winning winning(List<Integer> winningNumber) {
        return new Winning(winningNumber);
    }
}
