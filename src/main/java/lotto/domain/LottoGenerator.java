package lotto.domain;

import java.util.List;

public interface LottoGenerator {
    int LOTTO_SIZE = 6;

    List<LottoBall> createAutoLotto();
}
