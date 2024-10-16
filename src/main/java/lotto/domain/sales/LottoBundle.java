package lotto.domain.sales;

import lotto.constant.ErrorMessage;
import lotto.domain.number.Lotto;
import lotto.domain.prize.WinningPrize;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoBundle {

    private final List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static LottoBundle of(int quickPick) {
        return new LottoBundle(IntStream.range(0, quickPick)
            .mapToObj(i -> Lotto.create())
            .collect(Collectors.toList()));
    }

    public static LottoBundle of(String... manuals) {
        validateVariableArguments(manuals, ErrorMessage.INVALID_MANUAL_LOTTO);

        return new LottoBundle(Stream.of(manuals).map(Lotto::new).collect(Collectors.toList()));
    }

    private static void validateVariableArguments(Object[] objects, ErrorMessage errorMessage) {
        Objects.requireNonNull(objects);
        if (objects.length == 0) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public static LottoBundle of(LottoBundle... lottoBundles) {
        validateVariableArguments(lottoBundles, ErrorMessage.INVALID_LOTTO_INTEGRATION);

        return new LottoBundle(Arrays.stream(lottoBundles)
            .flatMap(lottoBundle -> lottoBundle.lottos().stream())
            .collect(Collectors.toList()));
    }

    public WinningPrize winningPrize(WinningLotto winningLotto) {
        WinningPrize winningPrize = new WinningPrize();
        for (Lotto lotto : lottos) {
            winningPrize.record(winningLotto.lottoPrize(lotto));
        }
        return winningPrize;
    }

    public Collection<Lotto> lottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
