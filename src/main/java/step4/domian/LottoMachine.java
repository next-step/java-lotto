package step4.domian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final List<Integer> INIT_LOTTO_NUM = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    public static List<Lotto> autoLottos(int lottoNum) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            lottoList.add(getNewLotto());
        }
        return lottoList;
    }

    private static Lotto getNewLotto() {
        return new Lotto(getAutoNum());
    }

    private static List<Integer> getAutoNum() {
        Collections.shuffle(INIT_LOTTO_NUM);
        return new ArrayList<>(INIT_LOTTO_NUM.subList(0, 6));
    }
}
