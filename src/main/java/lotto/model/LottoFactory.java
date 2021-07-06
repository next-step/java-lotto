package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static List<LottoNumber> numbers = new ArrayList<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numbers.add(LottoNumber.of(i));
        }
    }

    public List<Lotto> createAutoLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(createAutoLotto());
        }
        return lottos;
    }

    public List<Lotto> createManualLottos(int quantity, List<String> manualNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            String separator = ", ";
            String[] splitManualNumbers = manualNumbers.get(i).split(separator);
            List<LottoNumber> lottoNumbers = new ArrayList<>();
            for (int j = 0; j < LOTTO_SIZE; j++) {
                int lottoNumber = Integer.parseInt(splitManualNumbers[j]);
                lottoNumbers.add(LottoNumber.of(lottoNumber));
            }
            lottos.add(createManualLotto(lottoNumbers));
        }
        return lottos;
    }

    public static Lotto createAutoLotto() {
        Collections.shuffle(numbers);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            lottoNumbers.add(numbers.get(i));
        }
        //Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public static Lotto createManualLotto(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }
}
