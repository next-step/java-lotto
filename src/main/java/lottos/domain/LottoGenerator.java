package lottos.domain;

import lottos.domain.numbers.Numbers;

public interface LottoGenerator {

    Numbers generate(final int size);

}
