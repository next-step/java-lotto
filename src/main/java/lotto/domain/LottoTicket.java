package lotto.domain;

import lotto.domain.enums.LottoRank;
import lotto.ui.LottoHitInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<LottoNumber> lottoNumbers;


    protected LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket createAutoLotto() {
        List<LottoNumber> lottoNumbers = createAutoLottoTicket();
        return new LottoTicket(lottoNumbers);
    }

    public static LottoTicket createManualLotto(final List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        return new LottoTicket(lottoNumbers);
    }

    private static List<LottoNumber> createAutoLottoTicket() {
        List<Integer> numbers = new ArrayList<Integer>();

        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        return numbers.subList(0, 6)
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public int getTicketSize() {
        return lottoNumbers.size();
    }

    public LottoRank getHitCount(final LottoHitInfo hitInfo) {
        List<LottoNumber> hitNumbers = hitInfo.getHitNumbers();
        LottoNumber bonusNumber = hitInfo.getBonusNumber();

        int totalCount = 0;

        for (LottoNumber number : hitNumbers) {
            totalCount += checkHit(number);
        }

        if (totalCount < 6) {
            boolean isHitBonus = hasBonusNumber(bonusNumber);
            return LottoRank.findRank(totalCount, isHitBonus);
        }

        return LottoRank.findRank(totalCount, false);
    }


    private int checkHit(final LottoNumber number) {
        return isContain(number) ? 1 : 0;
    }

    public boolean hasBonusNumber(final LottoNumber number) {
        return isContain(number);
    }

    private boolean isContain(final LottoNumber number) {
        return this.lottoNumbers
                .stream()
                .anyMatch(lottoNumber -> lottoNumber.match(number));
    }

    private static void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또숫자는 6개여야 합니다. 현재 SIZE: " + lottoNumbers.size());
        }
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
