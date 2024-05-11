import java.util.List;
import java.util.stream.Collectors;

public class LottoDraw {
    public static WinningResults draw(Lottos lottos, LottoNumbers winningLottoNumbers) {
        List<WinningResult> winningResultList = lottos.get().stream()
                .map(i -> new WinningResult(i, winningLottoNumbers))
                .collect(Collectors.toList());

        return new WinningResults(winningResultList);
    }
}
