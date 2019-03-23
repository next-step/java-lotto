package lotto.domain;

import lotto.vo.LottoNo;

import java.util.ArrayList;
import java.util.List;

public class LottoMarket {

    private static LottoMachine lottoMachine = LottoMachine.getInstance();

    /**
     * 구매한 개수만큼 로또 생성
     *
     * @param buyCount 구매개수
     * @return 구매한 로또들
     */
    public static List<Lotto> createLottos(List<Lotto> lottos, int buyCount) throws IllegalArgumentException {
        //로또 번호생성
        for (int i = 0; i < buyCount; i++) {
            Lotto lotto = new Lotto(Lotto.createNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    /**
     * 수동입력 로또 생성
     */
    public static List<Lotto> createDirectNumbers(List<String[]> directNumbers) throws IllegalArgumentException {

        List<Lotto> lottos = new ArrayList<>();

        for (String[] directNumber : directNumbers) {
            List<LottoNo> numbers = lottoMachine.makeDuplicateNumbers(directNumber);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return lottos;
    }
}
