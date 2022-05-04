package step2.service;

import step2.domain.LottoPickStrategy;

import java.util.ArrayList;
import java.util.List;

public class TestPick implements LottoPickStrategy {

    private List<Integer> list;

    public TestPick(List<Integer> list) {
        this.list = list;
    }

    @Override
    public List<Integer> numberPick() {
        return this.list;
    }
}
