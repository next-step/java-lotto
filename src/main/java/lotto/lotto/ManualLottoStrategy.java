package lotto.lotto;

import lotto.system.Const;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ManualLottoStrategy implements LottoGeneratorStrategy {

    public ManualLottoStrategy() {
    }

    @Override
    public Lottos generateLotto(LottoParameters lottoParameters) {
        Optional<String[]> optional = Optional.ofNullable(lottoParameters.getManualLottos());
        List<Lotto> lottos = new ArrayList<>();

        if (optional.isPresent()) {
            lottos = generate(optional.get());
        }

        return new Lottos(lottos);
    }

    private List<Lotto> generate(String[] array) {
        List<Lotto> result = new ArrayList<>();

        for (String str : array) {
            List<String> lottoStr = Arrays.asList(str.split(Const.DELIMITER));
            List<LottoNumber> lottoNumber = lottoStr.stream()
                    .map(LottoNumber::from)
                    .collect(Collectors.toList());

            validateLottoNumberCnt(lottoNumber);

            Lotto lotto = new Lotto(lottoNumber);
            result.add(lotto);
        }

        return result;
    }

    private void validateLottoNumberCnt(List<LottoNumber> lottoNumber) {
        if (lottoNumber.size() != Const.LOTTO_CNT) {
            throw new IllegalArgumentException("로또 번호는 6개 입니다.");
        }
    }
}
