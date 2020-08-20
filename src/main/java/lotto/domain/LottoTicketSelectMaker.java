package lotto.domain;

import utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketSelectMaker implements LottoTicketMaker {
    private static final String DELIMITER = ",";

    private List<List<Integer>> selectLottoNumbers;
    private int buyCount;

    public LottoTicketSelectMaker(List<String> selectLottoNumbers) {
        this.selectLottoNumbers = selectLottoNumbers.stream()
                .map(this::makeIntegerList)
                .collect(Collectors.toList());

        this.buyCount = selectLottoNumbers.size() - 1;
    }

    private List<Integer> makeIntegerList(String selectLottoNumber) {
        return Arrays.stream(selectLottoNumber.split(DELIMITER))
                .map(String::trim)
                .map(StringUtils::toNumber)
                .collect(Collectors.toList());
    }

    @Override
    public LottoTicket create() {
        List<LottoNumber> lottoNumbers = selectLottoNumbers.get(buyCount)
                .stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        buyCount--;

        return new LottoTicket(lottoNumbers);
    }
}
