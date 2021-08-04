package lotto.domain;

import java.util.Set;

public class CollectionOflLottoNumbers {
    private final Set<LottoNumbers> collectionOflLottoNumbers;

    private CollectionOflLottoNumbers(Set<LottoNumbers> collectionOflLottoNumbers) {
        this.collectionOflLottoNumbers = collectionOflLottoNumbers;
    }

    public static CollectionOflLottoNumbers of(Set<LottoNumbers> collectionOflLottoNumbers) {
        return new CollectionOflLottoNumbers(collectionOflLottoNumbers);
    }

    public Set<LottoNumbers> getCollectionOfLottoNumbers() {
        return collectionOflLottoNumbers;
    }
}
