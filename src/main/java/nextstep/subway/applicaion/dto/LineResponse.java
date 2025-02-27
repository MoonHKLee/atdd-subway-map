package nextstep.subway.applicaion.dto;

import java.util.ArrayList;
import java.util.List;
import nextstep.subway.domain.Line;

public class LineResponse {
    private final Long id;
    private final String name;
    private final String color;
    private final List<StationResponse> stations;

    public LineResponse(Long id, String name, String color, List<StationResponse> stations) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.stations = stations;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public List<StationResponse> getStations() {
        return stations;
    }

    public static LineResponse convertedByEntity(Line line) {
        List<StationResponse> stationResponses = new ArrayList<>();
        stationResponses.add(StationResponse.convertedByEntity(line.getUpEndpoint()));
        stationResponses.add(StationResponse.convertedByEntity(line.getDownEndpoint()));
        return new LineResponse(line.getId(), line.getName(), line.getColor(), stationResponses);
    }

}
