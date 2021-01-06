package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int LOTTO_TICKET_NUMBER = 6;
    public static final int LOTTO_TICKET_PRICE = 1_000;
    private final List<LottoNumber> list = new ArrayList<>();

    public LottoTicket(List<LottoNumber> subList) {
        validateSize(subList);
        validateDuplication(subList);
        this.list.addAll(subList);
    }

    public static int countPurchasable(int money) {
        return money / LOTTO_TICKET_PRICE;
    }

    private void validateDuplication(List<LottoNumber> subList) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(subList);
        if (lottoNumbers.size() != LOTTO_TICKET_NUMBER) {
            System.out.println(
                "입력된 list 번호: " + subList.stream()
                    .map(lottoNumber -> lottoNumber.getNumber().toString())
                    .collect(Collectors.joining(", ")));
            throw new IllegalArgumentException("로또 번호는 중복 가능한 번호가 존재하면 안됩니다.");
        }
    }

    private void validateSize(List<LottoNumber> subList) {
        if (subList.size() != LOTTO_TICKET_NUMBER) {
            System.out.println("입력된 list size: " + subList.size());
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_TICKET_NUMBER + " 개만 가능합니다.");
        }
    }

    public int size() {
        return this.list.size();
    }
}
