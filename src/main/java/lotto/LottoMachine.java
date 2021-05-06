package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static lotto.Lotto.CANDIDATE_LOTTO_NUMBER_SIZE;
import static lotto.Lotto.CORRECT_LOTTO_NUMBERS_SIZE;

public class LottoMachine {

    public int countPurchasable(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public List<Lotto> makeBunchOfLotto(int purchaseAmount) {
        List<Lotto> bunchOfLotto = new ArrayList<>();
        int lottoCount = countPurchasable(purchaseAmount);
        for (int i = 0; i < lottoCount; i++) {
            bunchOfLotto.add(new Lotto(makeLottoNumbers()));
        }
        return bunchOfLotto;
    }
    // private 로 하고싶은데 테스트에서 사용하려면 public 이어야하고 그렇다는건 메서드가 다른 클래스로 가야할지도..?
    public static List<Integer> makeLottoNumbers() {
        HashSet<Integer> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < CORRECT_LOTTO_NUMBERS_SIZE){
            lottoNumbers.add(makeLottoNumber());
        }
        List lottoNumberList = new ArrayList(lottoNumbers);
        return lottoNumberList;
    }
    private static Integer makeLottoNumber() {
        return (int)(Math.random() * CANDIDATE_LOTTO_NUMBER_SIZE) + 1;
    }
}
