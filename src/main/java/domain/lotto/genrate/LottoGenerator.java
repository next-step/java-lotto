package domain.lotto.genrate;

import java.util.List;

public interface LottoGenerator {

    List<Integer> create();
    int getSize();
}
