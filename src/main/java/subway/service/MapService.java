package subway.service;

import java.util.List;
import subway.constant.Service;
import subway.domain.LineInfo;
import subway.domain.MapRepository;
import subway.domain.Station;
import subway.view.SubwayOutputView;

public class MapService {
    private final MapRepository mapRepository;

    public MapService() {
        this.mapRepository = MapRepository.getInstance();
    }

    public void displayMap() {
        boolean isFirst = false;
        for (LineInfo lineInfo : mapRepository.map()) {
            if (isFirst) {
                SubwayOutputView.printLineSpace();
            }
            isFirst = true;
            printLineHead(lineInfo.getLine().getName());
            printStations(lineInfo.getStations());
        }
    }

    private void printLineHead(String line) {
        SubwayOutputView.print(Service.FORMAT.getInfo(line));
        SubwayOutputView.print(Service.INFO_LINE.getInfo());
    }

    private void printStations(List<Station> stations) {
        stations.forEach(station -> {
            SubwayOutputView.print(Service.FORMAT.getInfo(station.getName()));
        });
    }
}
