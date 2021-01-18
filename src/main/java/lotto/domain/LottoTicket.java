package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {

    public static final int Lotto_NUMBER_COUNT = 6;
    public static final int LOTTO_TICKET_PRICE = 1_000;
    private final List<LottoNumber> list;

    public LottoTicket(List<LottoNumber> subList) {
        validateSize(subList);
        validateDuplication(subList);
        this.list = new ArrayList<>(subList);
        Collections.sort(this.list);
    }

    public static int countPurchasable(int money) {
        return money / LOTTO_TICKET_PRICE;
    }

    private void validateDuplication(List<LottoNumber> subList) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(subList);
        if (lottoNumbers.size() != Lotto_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복 가능한 번호가 존재하면 안됩니다.");
        }
    }

    private void validateSize(List<LottoNumber> subList) {
        if (subList.size() != Lotto_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 " + Lotto_NUMBER_COUNT + " 개만 가능합니다.");
        }
    }

    public int size() {
        return this.list.size();
    }

    public String joiningResult() {
        return this.list
            .stream()
            .map(lottoNumber -> lottoNumber.getNumber().toString())
            .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
            "list=" + list +
            '}';
    }

    public boolean contain(LottoNumber lottoNumber) {
        long count = this.list.stream()
            .filter(lottoNumber1 -> lottoNumber1.equals(lottoNumber))
            .count();
        return count > 0;
    }

    public long countSameNumber(LottoTicket lottoTicket) {
        return lottoTicket.list
            .stream()
            .map(this::contain)
            .filter(aBoolean -> aBoolean)
            .count();

    }

}
