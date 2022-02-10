package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.Converter;

public class LottosDTO {
    private List<String> lottos;

    public LottosDTO(List<String> lottos) {
        this.lottos = lottos;
    }

    public List<String> get() {
        return lottos;
    }

    public void set(List<String> lottos) {
        this.lottos = lottos;
    }

    public static LottosDTO from(List<Lotto> lottos) {
        List<String> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(Converter.LottoToString(lotto));
        }
        return new LottosDTO(result);
    }
}
