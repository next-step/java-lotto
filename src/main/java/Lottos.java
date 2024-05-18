import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> value;

    public Lottos(Lotto... value) {
        this(Arrays.stream(value).collect(Collectors.toList()));
    }

    public Lottos(List<Lotto> value) {
        this.value = value;
    }

    public int size() {
        return this.value.size();
    }

    public Lotto findByOrder(int order) {
        return this.value.get(order);
    }

    public List<Lotto> get() {
        return this.value;
    }

    public WinningResults draw(Lotto winningNumbers, LottoNumber bonusNumber) {
        List<WinningResult> winningResultList = this.value.stream()
                .map(i -> new WinningResult(i, winningNumbers, bonusNumber))
                .collect(Collectors.toList());

        return new WinningResults(winningResultList, bonusNumber);
    }
}
