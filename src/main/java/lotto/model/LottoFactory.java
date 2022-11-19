package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class LottoFactory {
    public static final int LOTTO_MAX_LENGTH = 6;
    private static final int LOTTO_INIT_LENGTH = 0;
    private final int manualQuantity;

    public LottoFactory(int manualQuantity, Price price) {
        validation(manualQuantity, price);
        this.manualQuantity = manualQuantity;
    }

    private void validation(int manualQuantity, Price price) {
        price.manualValidation(manualQuantity);
    }

    public List<Lotto> addLotto(int auto, final Map<Integer, List<String>> manualLotto) {
        List<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < manualQuantity; count++) {
            lottos.add(new Lotto(createManualLotto(manualLotto, count)));
        }

        for (int i = 0; i < auto; i++) {
            lottos.add(new Lotto(createAutoLotto()));
        }

        return lottos;
    }

    private Set<LottoNumber> createManualLotto(final Map<Integer, List<String>> manualLotto, int count) {
        return manualLotto.get(count).stream()
                .map(manualLottoNumber -> LottoNumber.cacheLottoNumber(Integer.parseInt(manualLottoNumber)))
                .collect(Collectors.toSet());
    }

    private Set<LottoNumber> createAutoLotto() {
        List<LottoNumber> list = new ArrayList<>(LottoNumber.cache().values());
        Collections.shuffle(list);
        return new HashSet<>(list.subList(LOTTO_INIT_LENGTH, LOTTO_MAX_LENGTH));
    }

    public int rest(Price price) {
        return price.restPrice(manualQuantity);
    }

    public int getManualQuantity() {
        return manualQuantity;
    }
}
