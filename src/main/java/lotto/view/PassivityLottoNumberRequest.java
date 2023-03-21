package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.*;

public class PassivityLottoNumberRequest {
    private final List<LottoNumbers> lottoNumbersList;

    public PassivityLottoNumberRequest(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    public static PassivityLottoNumberRequest inputLottoPrice(int passivityPurchasesNumber) {
        List<LottoNumbers> lottoNumbers = lottoNumberList(passivityPurchasesNumber);
        return new PassivityLottoNumberRequest(lottoNumbers);
    }

    private static List<LottoNumbers> lottoNumberList(int passivityPurchasesNumber) {
        final Scanner sc = new Scanner(System.in);
        final List<LottoNumbers> passivityLottoNumberList = new ArrayList<>();

        if (passivityPurchasesNumber == 0) {
            return passivityLottoNumberList;
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        for (int i = 0; i < passivityPurchasesNumber; i++) {
            passivityLottoNumberList.add(lottoNumbers(sc.next()));
        }

        return passivityLottoNumberList;
    }

    private static LottoNumbers lottoNumbers(String inputLottoNumber) {
        Set<LottoNumber> numberList = new HashSet<>();

        for (String number : inputLottoNumber.split(",")) {
            numberList.add(new LottoNumber(Integer.parseInt(number)));
        }
        return new LottoNumbers(numberList);
    }

    public List<LottoNumbers> getPassivityLottoNumberList() {
        return lottoNumbersList;
    }
}
