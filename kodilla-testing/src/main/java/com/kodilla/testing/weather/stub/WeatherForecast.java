package com.kodilla.testing.weather.stub;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
public class WeatherForecast {
    private Temperatures temperatures;
    public WeatherForecast(Temperatures temperatures){
        this.temperatures = temperatures;
    }
    public Map<String, Double> CalculateForecast(){
        Map<String, Double> resultMap = new HashMap<>();

        for(Map.Entry<String,Double> temperature : temperatures.getTemperatures().entrySet()){
            //adding 1 celsius degree to current value
            //as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }
    public double CalculateAverageTemperature(){
        double sum = 0;
        int howMuch = 0;
        for(Map.Entry<String, Double> average : temperatures.getTemperatures().entrySet()){
            double num = average.getValue();
            howMuch++;
            sum += num;
        }
        return sum/howMuch;
    }

    public double CalculateMedianOfTemperature(){
        int length = temperatures.getTemperatures().size();
        double[] arr = new double[length];
        int i = 0;
        for(Map.Entry<String, Double> value : temperatures.getTemperatures().entrySet()){
            arr[i] = value.getValue();
            i++;
        }
        Arrays.sort(arr);
        return arr[length/2];
    }
}
