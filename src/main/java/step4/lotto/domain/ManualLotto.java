package step4.lotto.domain;

import lotto.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLotto implements LottoMatchable{
    private List<Lotto> manualLottos;

    public ManualLotto(List<String> manualLotto){
        this.manualLottos = toLottos(manualLotto);
    }

    private List<Lotto> toLottos(List<String> manualLotto) {
        List<Lotto> lottos = new ArrayList<>();
        if(manualLotto == null){
            return  lottos;
        }
        for (String numbers : manualLotto) {
            lottos.add(new Lotto(StringUtil.stringToList(numbers)));
        }
        return  lottos;
    }

    @Override
    public void lottoMatching(Result result, WinningLotto winningLotto) {
        this.manualLottos.stream()
                .forEach(lotto -> result.plusRankCount(lottoRank(lotto, winningLotto)));
    }

    @Override
    public Rank lottoRank(Lotto userLotto, WinningLotto winningLotto) {
        return winningLotto.match(userLotto);
    }

    @Override
    public String toString() {
        String result = manualLottos.stream()
                .map(n -> n.toString())
                .collect(Collectors.joining("\n"));
        return result;
    }

    public int size() {
        return manualLottos.size();
    }
}
