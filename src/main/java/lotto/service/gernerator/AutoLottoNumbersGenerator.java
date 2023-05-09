package lotto.service.gernerator;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.model.LottoInformation;
import lotto.model.request.ReqAutoLotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AutoLottoNumbersGenerator implements LottoNumbersGenerator<ReqAutoLotto> {

    private static final int LOTTO_NUMBER_GROUP_LENGTH = 6;

    @Override
    public List<LottoNumbers> bulkGenerateLottoNumbers(ReqAutoLotto reqAutoLotto) {

        Money requestMoney = reqAutoLotto.getMoney();
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        while (isEnoughBuyMoney(requestMoney)) {
            requestMoney = calculateCurrentMoney(requestMoney);
            LottoNumbers lottoNumbers = generateLottoNumbers();
            lottoNumbersList.add(lottoNumbers);
        }

        return lottoNumbersList;
    }

    @Override
    public LottoNumbers generateLottoNumbers(ReqAutoLotto reqAutoLotto) {
        Money requestMoney = reqAutoLotto.getMoney();
        if (!isEnoughBuyMoney(requestMoney)) {
            throw new IllegalArgumentException("금액을 확인해주세요 :(");
        }

        return generateLottoNumbers();
    }

    private LottoNumbers generateLottoNumbers() {
        Set<LottoNumber> lottoNumberList = new HashSet<>();

        while (lottoNumberList.size() < LOTTO_NUMBER_GROUP_LENGTH) {
            lottoNumberList.add(LottoNumber.provideLottoNumber());
        }

        return new LottoNumbers(toList(lottoNumberList));
    }

    private List<LottoNumber> toList(Set<LottoNumber> lottoNumberList) {
        return new ArrayList<>(lottoNumberList).stream()
                .sorted(LottoNumber::compareTo)
                .collect(Collectors.toUnmodifiableList());
    }

    private Money calculateCurrentMoney(Money money) {
        return money.minus(LottoInformation.LOTTO_FEE);
    }

    private boolean isEnoughBuyMoney(Money money) {
        return money.isGreaterThan(LottoInformation.LOTTO_FEE);
    }
}
