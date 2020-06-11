package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumbers {

    private static final ManualLottoNumbers EMPTY = ManualLottoNumbers.create(new ArrayList<>());

    private final List<List<LottoNumber>> lottoNumbers;

    private ManualLottoNumbers(List<List<LottoNumber>> lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("로또 수동 번호를 입력해주세요");
        }

        this.lottoNumbers = lottoNumbers;
    }

    public static ManualLottoNumbers create(List<List<LottoNumber>> lottoNumbers) {
        return new ManualLottoNumbers(lottoNumbers);
    }

    public static ManualLottoNumbers empty() {
        return EMPTY;
    }

    public int getManualCount() {
        return lottoNumbers.size();
    }

    public List<Lotto> toLottos() {
        return lottoNumbers.stream()
                .map(Lotto::createManual)
                .collect(Collectors.toList());
    }
}
