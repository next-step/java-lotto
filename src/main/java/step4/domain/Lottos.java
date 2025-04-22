package step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 로또 묶음(컬렉션 객체)
 * 여러 장의 Lotto를 불변 컬렉션으로 가지고 있음
 * 행위 : matchResultMap(각 로또 티켓에 대해 우승번호를 받아서 MatchResult Map 생성)
 * WinningNumber에 Lotto를 보내 한 장씩 평가해 달라는 메시지를 전달함
 */
public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    /**
     * 전부 자동으로 구매시
     */
    public static Lottos ofAutoCount(int count) {
        return new Lottos(generateLottosByCount(count));
    }

    /**
     * 일부 수동구매시
     */
    public static Lottos ofMixed(List<Lotto> manualLottos, int count) {
        List<Lotto> combined = new ArrayList<>(manualLottos);
        combined.addAll(generateLottosByCount(count));
        return new Lottos(combined);
    }

    private static List<Lotto> generateLottosByCount(int count) {
        return IntStream.range(0, count)
            .mapToObj(i -> Lotto.ofAuto())
            .collect(Collectors.toList());
    }

    public int size() {
        return lottos.size();
    }

    public Map<Lotto, MatchResult> matchResultMap(WinningNumber winningNumber) {
        return lottos.stream()
            .collect(Collectors.toMap(
                lotto -> lotto,
                winningNumber::match
            ));
    }

    public String allLottoNumbersToString() {
        return lottos.stream()
            .map(Lotto::numbersToString)
            .collect(Collectors.joining("\n"));
    }
}
