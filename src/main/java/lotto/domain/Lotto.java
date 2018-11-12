package lotto.domain;

import lotto.utils.GenerateLotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private GenerateLotto generateLotto;
    private LottoNumber lottoNumber;

    public Lotto(final GenerateLotto generateLotto) {
        this.generateLotto = generateLotto;
    }

    public void createLotto() {
        this.lottoNumber = new LottoNumber(this.generateLotto.create());
    }

    public void createLotto(final String lottoNumber) {
        this.lottoNumber = new LottoNumber(new ArrayList<>(toIntList(toInts(split(lottoNumber)))));
    }

    public LottoNumber getLottoNumber() {
        return lottoNumber;
    }

    public boolean isMatchNumber(final LottoNumber sourceLottoNumber, final int point) {
        return this.lottoNumber.isMatchNumber(sourceLottoNumber, point);
    }

    private int[] toInts(final String[] lottoNumbers) {
        final int[] ints = new int[lottoNumbers.length];
        for (int i = 0; i < lottoNumbers.length; i++) {
            final String text = lottoNumbers[i];
            ints[i] = (convertInt(text));
        }
        return ints;
    }

    private List<Integer> toIntList(final int[] lottoNumbers) {
        final List<Integer> ints = new ArrayList<>();
        for (int num : lottoNumbers) {
            ints.add(num);
        }
        return ints;
    }

    private String[] split(final String lottoNumbers) {
        return lottoNumbers.split(",");
    }

    private int convertInt(final String text) {
        return Integer.parseInt(text);
    }

}
