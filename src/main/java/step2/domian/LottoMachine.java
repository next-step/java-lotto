package step2.domian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final List<Integer> initLottoNum = IntStream.rangeClosed(0, 45).boxed().collect(Collectors.toList());

    public static LottoWallet autoLottos(int lottoNum) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            lottoList.add(getNewLotto());
        }
        return new LottoWallet(lottoList);
    }

    private static Lotto getNewLotto() {
        return new Lotto(getAutoNum());
    }

    private static List<Integer> getAutoNum() {
        Collections.shuffle(initLottoNum);
        return new ArrayList<>(initLottoNum.subList(0, 6));
    }
}
