package lotto;

import java.util.List;

public interface LottoGenerator {
    List<LottoNumber> generate();
    int getPrice();
}
