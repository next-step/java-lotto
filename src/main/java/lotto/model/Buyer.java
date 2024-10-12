package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    public static final String LOTTO_IS_NOT_ALLOWED_DUPLICATED = "로또는 중복된 숫자로 구매할수 없습니다.";
    private final List<Lotto> lottoes;

    private Buyer(List<Lotto> lottoes) {
        this.lottoes = lottoes;
    }

    public static Buyer of(List<Lotto> lottoes) {
        List<Lotto> result = new ArrayList<>();
        for (Lotto lotto : lottoes) {
            validateLotto(result, lotto);
            result.add(lotto);
        }
        return new Buyer(result);
    }

    private static void validateLotto(List<Lotto> result, Lotto lotto) {
        boolean isDuplicatedLotto = result.contains(lotto);//NOTE: Lotto equals and hash 사용
        if (isDuplicatedLotto) {
            throw new IllegalArgumentException(LOTTO_IS_NOT_ALLOWED_DUPLICATED);
        }
    }

    public int size() {
        return this.lottoes.size();
    }

    public List<Lotto> value() {
        return this.lottoes;
    }
}
