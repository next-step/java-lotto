package lottoauto.domain.aggregate;

import java.util.List;

@FunctionalInterface
public interface CustomShuffle {

    List<Integer> makeShuffle();
}
