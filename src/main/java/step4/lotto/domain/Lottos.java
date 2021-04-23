package step4.lotto.domain;

import step4.lotto.util.StringUtil;

import java.util.List;
import java.util.Objects;

public class Lottos {
    private ManualLotto manualLotto;
    private AutoLotto autoLotto;

    public Lottos(List<String> manualLotto, int autoCount) {
        this.manualLotto = new ManualLotto(manualLotto);
        this.autoLotto = new AutoLotto(autoCount);
    }

    public Result matching(WinningLotto winningLotto){
        Result result = new Result();
        manualLotto.matching(result, winningLotto);
        autoLotto.matching(result, winningLotto);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos = (Lottos) o;
        return Objects.equals(manualLotto, lottos.manualLotto) && Objects.equals(autoLotto, lottos.autoLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualLotto, autoLotto);
    }

    @Override
    public String toString() {
        String manualText = manualLotto.toString();
        String autoText = autoLotto.toString();
        return StringUtil.checkString(manualText) ? manualText + "\n" + autoText : autoText;
    }

    public int lottoSize() {
        return  manualLotto.size() + autoLotto.size();
    }
}
