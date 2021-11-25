package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private static final int MIN_COUNT = 0; //이 변수로 인해서 일급 컬렉션이 아니게 됨?

    private final List<Lotto> lottos;

    public Lottos(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("구매 개수는 0 미만일 수 없습니다.");
        }

        // 이 부분을 개선할 수는 없을까?
        lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }

    // 이런 메소드는 테스트를 해야하는가? 단순하게 다른 도메인의 책임을 위임하는 역할인 것 같아 테스트 하지 않아도 된다고 생각.
    public Ranks checkWinning(Lotto winLotto) {
        return new Ranks(lottos.stream()
                .mapToInt(winLotto::countMatch)
                .mapToObj(Rank::valueOf)
                .collect(Collectors.toList())
        );
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int size() {
        return this.lottos.size();
    }

}
