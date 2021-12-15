package lotto.domain;

import java.util.List;

public class LottoGame {
    public static int match(List<Integer> userLotto, List<Integer> winningLotto, int bonusNo) {
        // TODO 인자에 대한 유효성 체크
        // * 로또 한 장은 6개의 번호여야 한다.
        // * 6개의 각 숫자는 1에서 45 사이의 값이어야 한다.
        // * 6개의 값은 중복된 값이 있으면 안된다.
        // * 당첨 번호의 경우는 보너스 번호가 1에서 45 사이의 값이어야 하여, 보너스 번호는 당첨 번호 6개의 값이 아니어야 한다.

        int matchCount = match(userLotto, winningLotto);
        if (matchCount == 6) {
            return 1;
        }
        boolean matchBonus = userLotto.contains(bonusNo);
        if (matchCount == 5 && matchBonus) {
            return 2;
        }
        if (matchCount > 2) {
            return 6 - matchCount + 2;
        }
        return 0;
    }

    private static int match(List<Integer> userLotto, List<Integer> winningLotto) {
        int count = 0;
        for (Integer lottoNumber : userLotto) {
            if (winningLotto.contains(lottoNumber)) {
                count += 1;
            }
        }
        return count;
    }
}
