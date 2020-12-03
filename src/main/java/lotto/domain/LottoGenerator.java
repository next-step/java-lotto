package lotto.domain;

import lotto.domain.game.Lotto;
import lotto.domain.game.LottoNumberSet;
import lotto.domain.game.LottoNumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created By mand2 on 2020-11-19.
 * 로또 번호 6개 자동 생성하는 객체
 */
public class LottoGenerator {

    private static List<LottoNumber> lottoNumbers;
    private static final String tokenizer = ", ";

    static {
        lottoNumbers = IntStream.rangeClosed(LottoNumber.VALID_MIN_NUMBER, LottoNumber.VALID_MAX_NUMBER)
                .mapToObj(LottoNumber::from)
                .collect(toList());
    }

    private LottoGenerator() {}

    public static Lottos generate(int totalRound) {
        return Lottos.of(automateLotto(totalRound));
    }

    public static Lottos generate(SeedMoney seedMoney, InputManualLotto inputManualLotto) {
        int totalRounds = seedMoney.round();
        int manualRounds = inputManualLotto.getRound();
        int autoRounds = totalRounds - manualRounds;

        List<Lotto> manual = manualLotto(inputManualLotto);
        List<Lotto> auto = automateLotto(autoRounds);

        return Lottos.of(Stream.concat(manual.stream(), auto.stream()).collect(toList())
                    , manualRounds, autoRounds);
    }

    private static List<Lotto> manualLotto(InputManualLotto inputManualLotto) {
        return inputManualLotto.getInputLottos().stream()
                .map(manual -> convertToLottoNumberSet(manual))
                .map(Lotto::of)
                .collect(toList())
                ;
    }

    private static LottoNumberSet convertToLottoNumberSet(String manualLottoNumber) {
        return Arrays.stream(splitLottoNumber(manualLottoNumber))
                .map(LottoNumber::from)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoNumberSet::of));
    }

    private static String[] splitLottoNumber(String manualLottoNumber) {
        return manualLottoNumber.split(tokenizer);
    }

    private static List<Lotto> automateLotto(int autoRound) {
        return Stream.generate(() -> Lotto.of(LottoNumberSet.of(convert())))
                .limit(autoRound)
                .collect(toList())
                ;
    }

    private static List<LottoNumber> convert() {
        shuffle();
        return lottoNumbers.subList(0, LottoNumberSet.VALID_LOTTO_SIZE);
    }

    private static void shuffle() {
        Collections.shuffle(lottoNumbers);
    }


}
