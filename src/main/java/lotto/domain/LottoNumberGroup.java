package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumberGroup {
    private static final int LOTTO_NUMBER_GROUP_LENGTH = 6;
    private List<LottoNumber> lottoNumberGroup = new ArrayList<>();

    public LottoNumberGroup() {
    }

    public LottoNumberGroup(List<LottoNumber> lottoNumberGroup) {
        this.lottoNumberGroup = lottoNumberGroup;
    }

    public LottoNumberGroup aggregateNonDuplicateLottoNumber() {
        Set<LottoNumber> lottoNumberList = new HashSet<>();

        while (lottoNumberList.size() < LOTTO_NUMBER_GROUP_LENGTH) {
            lottoNumberList.add(LottoNumber.provideLottoNumber());
        }

        return new LottoNumberGroup(toList(lottoNumberList));
    }

    private List<LottoNumber> toList(Set<LottoNumber> lottoNumberList) {
        return new ArrayList<>(lottoNumberList).stream()
                .sorted(LottoNumber::compareTo)
                .collect(Collectors.toUnmodifiableList());
    }

    public LottoNumberGroup initializedManualLottoNumber(List<Integer> requestNumberList) {
        validateLottoNumberLength(requestNumberList);
        validateSameNumber(requestNumberList);


        List<LottoNumber> lottoNumberList = requestNumberList.stream()
                .map(LottoNumber::provideLottoNumber)
                .sorted(LottoNumber::compareTo)
                .collect(Collectors.toUnmodifiableList());

        return new LottoNumberGroup(lottoNumberList);
    }

    public int countMatchingLottoNumber(LottoNumberGroup lottoNumberGroup) {
        return findMatchingLottoNumber(lottoNumberGroup).size();
    }

    private void validateLottoNumberLength(List<Integer> lottoNumberList) {

        if (lottoNumberList.size() != LOTTO_NUMBER_GROUP_LENGTH) {
            throw new IllegalArgumentException("로또 번호는 6개 입력 해주셔야해요 :(");
        }
    }

    private void validateSameNumber(List<Integer> lottoNumberList) {
        Set<Integer> removeDuplicateLottoNumber = new HashSet<>(lottoNumberList);

        if (removeDuplicateLottoNumber.size() != LOTTO_NUMBER_GROUP_LENGTH) {
            throw new IllegalArgumentException("중복된 로또번호가 존재해요 :(");
        }
    }

    private List<LottoNumber> filterMatchingLottoNumber(List<LottoNumber> lottoNumberList) {
        return lottoNumberList.stream().filter(this::isMatchingLottoNumber)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<LottoNumber> findMatchingLottoNumber(LottoNumberGroup targetLottoNumberGroup) {
        return targetLottoNumberGroup.filterMatchingLottoNumber(this.lottoNumberGroup);
    }

    private boolean isMatchingLottoNumber(LottoNumber lottoNumber) {
        return lottoNumberGroup.stream()
                .anyMatch(lottoNumber::isSameLottoNumber);
    }

    public int getLottoNumberGroupSize() {
        return lottoNumberGroup.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberGroup that = (LottoNumberGroup) o;
        return lottoNumberGroup.equals(that.lottoNumberGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberGroup);
    }

    @Override
    public String toString() {
        return lottoNumberGroup.toString();
    }
}

