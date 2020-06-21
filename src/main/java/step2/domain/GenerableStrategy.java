package step2.domain;

import java.util.List;

public interface GenerableStrategy {

    List<LottoNumber> generate(int start, int end, int count);
}
