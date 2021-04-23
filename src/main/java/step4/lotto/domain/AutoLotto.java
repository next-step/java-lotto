package step4.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLotto implements LottoMatchable{
    private List<Lotto> autolottos;

    public AutoLotto(int count) {
        this.autolottos = toLotto(count);
    }

    private List<Lotto> toLotto(int count) {
        List<Lotto> auto = new ArrayList<>();
        if(count < 1){
            return auto;
        }

        for (int i = 0; i < count; i++) {
            auto.add(new Lotto(LottoNumber.autoNumber()));
        }
        return auto;
    }

    @Override
    public void matching(Result result, WinningLotto winningLotto) {
        this.autolottos.stream()
                .forEach(lotto -> result.plusRankCount(match(lotto, winningLotto)));
    }

    @Override
    public Rank match(Lotto userLotto, WinningLotto winningLotto) {
        return winningLotto.match(userLotto);
    }

    @Override
    public String toString() {
        String result = autolottos.stream()
                .map(n -> n.toString())
                .collect(Collectors.joining("\n"));
        return result;
    }

    public int size() {
        return autolottos.size();
    }
}
