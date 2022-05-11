package lotto.model;

import lotto.dto.LottoResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Lottos {

    private final List<Lotto> lottos;

    public Lottos(long count, LottoGenerator lottoGenerator) {
        this(Stream.generate(lottoGenerator::get)
                .limit(count)
                .collect(Collectors.toList()));
    }

    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = new ArrayList<>(lottos);
    }

    private void validate(List<Lotto> lottos) {
        Objects.requireNonNull(lottos, "lottos 생성을 위한 입력이 올바르지 않습니다. lottos is null");
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> get() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoResult extractLottoResult(WinnerLotto winnerLotto) {
        validate(winnerLotto);

        return lottos.stream()
                .map(winnerLotto::getRank)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoResult::new));
    }

    private void validate(WinnerLotto winnerLotto) {
        Objects.requireNonNull(winnerLotto, "당첨 로또 번호 입력이 올바르지 않습니다. winnerLotto is null");
    }

    public static Lottos concatOf(Lottos oneLottos, Lottos anotherLottos) {
        Objects.requireNonNull(oneLottos, "합치려는 Lottos 객체는 null일 수 없습니다.");
        Objects.requireNonNull(anotherLottos, "합치려는 Lottos 객체는 null일 수 없습니다.");

        return new Lottos(Stream.concat(oneLottos.get().stream(), anotherLottos.get().stream())
                .collect(Collectors.toList()));
    }
}
