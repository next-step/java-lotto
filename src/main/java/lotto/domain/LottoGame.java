package lotto.domain;

import java.util.*;

public class LottoGame {

    public static Lotto autoGenerate() {
        // TODO: Collections.shuffle을 사용해야 한다.
        return Lotto.of(randomGenerateLottoNumbers());
    }

    private static List<LottoNumber> randomGenerateLottoNumbers() {
        HashSet<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < 6) {
            lottoNumbers.add(LottoNumber.of(getRandomNumber()));
        }
        return new ArrayList<>(lottoNumbers);
    }

    private static int getRandomNumber() {
        Random random = new Random();
        return LottoNumber.MIN_LOTTO_NUMBER + random.nextInt(LottoNumber.MAX_LOTTO_NUMBER);
    }

    public static List<Lotto> buy(long money) {
        // TODO: 돈만큼 구매
//        List<Lotto> Lottos = new ArrayList<>();
        return null;
    }
}
