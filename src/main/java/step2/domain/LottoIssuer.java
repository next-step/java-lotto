package step2.domain;

import java.util.ArrayList;
import java.util.List;


public class LottoIssuer {

    public static List<Lotto> issueAutoLottos(int issueCount) {
        List<Lotto> issuedAutoLottos = new ArrayList<>();

        for (int i = 0; i < issueCount; i++) {
            issuedAutoLottos.add(Lotto.create(LottoNumber.getRandomLottoNumber()));
        }

        return issuedAutoLottos;
    }

    public static List<Lotto> issueNonAutoLotto(List<String> customLottoNumberList) {
        List<Lotto> issuedNonAutoLottos = new ArrayList<>();

        for (int i = 0; i < customLottoNumberList.size(); i++) {
            issuedNonAutoLottos.add(Lotto.create(customLottoNumberList.get(i)));
        }

        return issuedNonAutoLottos;
    }
}


