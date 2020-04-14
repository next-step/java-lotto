package lotto.domain;

import java.util.*;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

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
        checkMoney(money);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            lottos.add(autoGenerate());
        }
        return lottos;
    }

    private static void checkMoney(long money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("천원 이하로 로또 구매 불가능");
        }
    }

    public static int match(Lotto lotto, Lotto winningLotto, LottoNumber bonusNumber) {
        int matchCount = 0;
        boolean bonusMatch = false;

        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (winningLotto.contains(lottoNumber)) {
                matchCount++;
            }
            if (lottoNumber.equals(bonusNumber)) {
                bonusMatch = true;
            }
        }

        return rank(matchCount, bonusMatch);
    }

    private static int rank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return 1;
        }
        if (matchCount == 5) {
            if (bonusMatch) {
                return 2;
            }
            return 3;
        }
        if (matchCount == 4) {
            return 4;
        }
        if (matchCount == 3) {
            return 5;
        }
        return 0;
    }
}
