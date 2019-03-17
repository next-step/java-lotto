package lotto.domain;

import lotto.dto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoMarket {

    /**
     * 구매한 개수만큼 로또 생성
     *
     * @param buyCount 구매개수
     * @return 구매한 로또들
     */
    public static List<Lotto> createLottos(int buyCount) {
        List<Lotto> lottos = new ArrayList<>();

        //로또 번호생성
        for (int i = 0; i < buyCount; i++) {
            Lotto lotto = new Lotto(createNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    /**
     * 각 로또별 번호 생성
     *
     * @return 한 로또의 번호들
     */
    public static List<Integer> createNumbers() {
        List<Integer> allNumber = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(toList());

        Collections.shuffle(allNumber);

        return allNumber.subList(0, 6);
    }
}
