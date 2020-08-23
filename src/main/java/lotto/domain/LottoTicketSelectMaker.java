package lotto.domain;

import utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketSelectMaker implements LottoTicketMaker {
    private static final String DELIMITER = ",";

    private List<List<Integer>> selectLottoNumbers;

    public LottoTicketSelectMaker(List<String> selectLottoNumbers) {
        this.selectLottoNumbers = selectLottoNumbers.stream()
                .map(this::makeIntegerList)
                .collect(Collectors.toList());
    }

    private List<Integer> makeIntegerList(String selectLottoNumber) {
        return Arrays.stream(selectLottoNumber.split(DELIMITER))
                .map(String::trim)
                .map(StringUtils::toNumber)
                .collect(Collectors.toList());
    }

    @Override
    public List<LottoTicket> create(BuyCount buyCount) {
        return selectLottoNumbers.stream()
                .map(list -> list.stream()
                        .map(LottoNumber::of)
                        .collect(Collectors.toList()))
                .map(LottoTicket::of)
                .collect(Collectors.toList());
    }
}
