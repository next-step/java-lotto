package lotto.view.result.statistic;

import lotto.model.Place;
import lotto.view.View;

public class PlaceView implements View {
    private static final String MATCH_FORMAT = "%d개 일치";
    private final Place place;
    private final int count;

    public PlaceView(Place place, int count) {
        this.place = place;
        this.count = count;
    }

    @Override
    public void render() {
        System.out.printf(matchFormat(), place.matches());
        System.out.printf("(%d원) - %d개", place.reward(), count);
        System.out.println();

    }

    private String matchFormat() {
        return place == Place.SECOND ? MATCH_FORMAT + ", 보너스 볼 일치" : MATCH_FORMAT;
    }
}
