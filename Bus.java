package team_project;

public class Bus {
    private String busId;
    private String routeCode;

    public Bus(String busId, String routeCode) {
        this.busId = busId;
        this.routeCode = routeCode;
    }

    public String getBusId() { return busId; }
    public String getRouteCode() { return routeCode; }

    @Override
    public String toString() {
        return "Bus{" + "busId='" + busId + '\'' + ", routeCode='" + routeCode + '\'' + "}";
    }
}
