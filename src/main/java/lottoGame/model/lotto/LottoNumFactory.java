package lottoGame.model.lotto;

import static lottoGame.model.lotto.LottoNum.MAX_NUM;
import static lottoGame.model.lotto.LottoNum.MIN_NUM;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LottoNumFactory {

    public static LottoNum createLottoNum() {
        return new LottoNum(
                new Random().nextInt(MIN_NUM, MAX_NUM)
        );
    }

    public static List<LottoNum> createLotto(int numCount) {
        if (numCount <= 0) {
            throw new IllegalArgumentException("생성할 로또의 로또번호 갯수를 입력해 주세요.");
        }

        Set<LottoNum> lottoNums = new HashSet<>();
        while (lottoNums.size() < numCount) {
            lottoNums.add(createLottoNum());
        }

        return new ArrayList<>(lottoNums);
    }


}
