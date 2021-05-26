package com.lotto.domain;

import com.lotto.exception.*;

import java.util.*;

public class ReqPurchaseLotto {
    private int totalPrice;
    private int totalCount;
    private int manualLottoCount;
    private int autoLottoCount;
    private List<Lotto> lottoList;

    public void setTotalPrice(String sTotalPrice)
            throws LottoPriceNumberFormatException, LottoPriceOutOfBoundsException {

        try {
            this.totalPrice = Integer.parseInt(sTotalPrice);
        } catch (NumberFormatException exception) {
            throw new LottoPriceNumberFormatException(sTotalPrice);
        }
        validateTotalPrice(totalPrice);
        totalCount = totalPrice / Lotto.UNIT_PRICE;
    }

    private static void validateTotalPrice(int totalPrice) {
        if (totalPrice < Lotto.UNIT_PRICE) {
            throw new LottoPriceOutOfBoundsException(totalPrice);
        }
    }

    public void setManualLottoCount(String sManualLottoCount)
            throws LottoManualCountNumberFormatException, LottoManualCountOutOfBoundsException {

        try {
            this.manualLottoCount = Integer.parseInt(sManualLottoCount);
        } catch (NumberFormatException exception) {
            throw new LottoManualCountNumberFormatException();
        }
        validateManualLottoCount(manualLottoCount);
        autoLottoCount = totalCount - manualLottoCount;
    }

    private void validateManualLottoCount(int manualLottoCount) throws LottoManualCountOutOfBoundsException {
        int maxCount = totalPrice / Lotto.UNIT_PRICE;
        if (manualLottoCount < 0 || manualLottoCount > maxCount) {
            throw new LottoManualCountOutOfBoundsException(maxCount);
        }
    }

    public void setLottoList(String[] sLottoList)
            throws NumberFormatException, LottoNumberOutOfBoundsException, IllegalLottoCountException {

        List<Lotto> lottoList = new ArrayList<>();

        for (String sNumbers : sLottoList) {
            lottoList.add(mapToLotto(sNumbers));
        }

        this.lottoList = lottoList;
    }

    public static Lotto mapToLotto(String sNumbers)
            throws LottoNumberFormatException, LottoNumberOutOfBoundsException, IllegalLottoCountException {

        String[] splitNumbers = sNumbers.split(",");
        TreeSet<LottoNumber> lottoNumbers = new TreeSet<>();
        for (String sNumber : splitNumbers) {
            lottoNumbers.add(LottoNumber.valueOf(sNumber));
        }

        return new Lotto(lottoNumbers);
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }
}
