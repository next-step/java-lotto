package lotto.service.gernerator;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.model.request.ReqManualLotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ManualLottoNumbersGenerator implements LottoNumbersGenerator<ReqManualLotto> {

    private static final int LOTTO_NUMBER_GROUP_LENGTH = 6;
    private static final String SPLIT_SEPARATOR = ",";


    @Override
    public List<LottoNumbers> bulkGenerateLottoNumbers(ReqManualLotto reqLotto) {
        List<String> requestNumberList = reqLotto.getRequestNumberList();

        return makeLottoNumberList(requestNumberList);
    }

    @Override
    public LottoNumbers generateLottoNumbers(ReqManualLotto reqLotto) {
        List<String> requestNumberList = reqLotto.getRequestNumberList();

        List<LottoNumbers> lottoNumbersList = makeLottoNumberList(requestNumberList);

        return lottoNumbersList.get(0);
    }

    private List<LottoNumbers> makeLottoNumberList(List<String> requestNumberList) {
        return requestNumberList.stream()
                .map(this::toNumeric)
                .map(this::generateLottoNumber)
                .map(this::generateLottoNumbers)
                .collect(Collectors.toList());
    }

    private List<Integer> toNumeric(String requestNumber) {
        return Arrays.stream(requestNumber.split(SPLIT_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<LottoNumber> generateLottoNumber(List<Integer> requestNumberList) {
        validate(requestNumberList);

        return requestNumberList.stream()
                .map(LottoNumber::provideLottoNumber)
                .sorted(LottoNumber::compareTo)
                .collect(Collectors.toUnmodifiableList());
    }

    private LottoNumbers generateLottoNumbers(List<LottoNumber> requestNumberList) {


        return new LottoNumbers(requestNumberList);
    }


    private void validate(List<Integer> requestNumberList) {
        validateLottoNumberLength(requestNumberList);
        validateSameNumber(requestNumberList);
    }

    private void validateLottoNumberLength(List<Integer> requestNumberList) {

        if (requestNumberList.size() != LOTTO_NUMBER_GROUP_LENGTH) {
            throw new IllegalArgumentException("로또 번호는 6개 입력 해주셔야해요 :(");
        }
    }

    private void validateSameNumber(List<Integer> requestNumberList) {
        Set<Integer> removeDuplicateLottoNumber = new HashSet<>(requestNumberList);

        if (removeDuplicateLottoNumber.size() != LOTTO_NUMBER_GROUP_LENGTH) {
            throw new IllegalArgumentException("중복된 로또번호가 존재해요 :(");
        }
    }


}
