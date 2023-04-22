package lotto.domain;

import lotto.domain.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LottoGenerator {

    private LottoGenerator() {
        throw new IllegalCallerException("잘못되 객체생성 입니다.");
    }

    public static List<Integer> generate() {
        List<Integer> lotto = createLottoNumbers();
        Collections.sort(lotto);
        return lotto;
    }

    private static List<Integer> createLottoNumbers() {
        List<Integer> lotto = new ArrayList<>(6);
        while (lotto.size() < 6) {
            addLottoNumber(lotto);
        }
        return lotto;
    }

    private static void addLottoNumber(List<Integer> lotto) {
        int generatedNumber = LottoNumberGenerator.generate();
        if (!lotto.contains(generatedNumber)) {
            lotto.add(generatedNumber);
        }
    }

}