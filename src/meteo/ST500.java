package meteo;

import java.time.LocalDateTime;

public class ST500 implements MeteoSensor{

    private SensorTemperature sensorTemperature;
    public ST500(SensorTemperature sensorTemperature){
        this.sensorTemperature = sensorTemperature;
    }
    @Override
    public int getId() {
        return sensorTemperature.identifier();
    }

    @Override
    public Float getTemperature() {
        return (float)sensorTemperature.temperature();
    }

    @Override
    public Float getHumidity() {
        return null;
    }

    @Override
    public Float getPressure() {
        return null;
    }

    @Override
    public LocalDateTime getDateTime() {
        int year = sensorTemperature.year();
        int day = sensorTemperature.day() - 1;
        int second = sensorTemperature.second();
        LocalDateTime localDateTime = LocalDateTime.of(year,1, 1,0,0,0)
                .plusDays(day).plusSeconds(second);
        return localDateTime;
    }
}