package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLottoGenerator implements LottoGenerator {

    @Override
    public List<LottoBall> createAutoLotto() {
        List<LottoBall> lottoBallList = LottoBall.getAllBalls();
        Collections.shuffle(lottoBallList);
        return lottoBallList.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toList());
    }
}
