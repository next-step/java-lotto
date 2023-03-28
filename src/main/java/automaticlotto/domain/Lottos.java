package automaticlotto.domain;

import automaticlotto.automaticexception.ExceptionCommand;
import automaticlotto.automaticexception.InputValueException;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validateLottos(lottos);
        this.lottos = lottos;
    }

    private void validateLottos(List<Lotto> lottos) {
        if (lottos == null || lottos.isEmpty()) {
            throw new InputValueException(ExceptionCommand.LOTTOS_EMPTY_EXCEPTION_MESSAGE);
        }
    }

    public static Lottos createLottos(int buyLottoNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyLottoNumbers; i++) {
            lottos.add(new Lotto(Lotto.sortLotto(Lotto.createLotto())));
        }
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
