package cz.vsb.smolka.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import cz.vsb.smolka.City;
import cz.vsb.smolka.connector.WeatherStackConnector;
import cz.vsb.smolka.dto.WeatherDto;
import cz.vsb.smolka.dto.WeatherStackDto;

@Service
public class WeatherService {
	public WeatherDto getWeatherForCity(City cityEnum) {
		WeatherStackConnector connector = new WeatherStackConnector();
		WeatherStackDto weatherstackData = connector.getWeatherForCity(cityEnum);
		return transformDto(weatherstackData);
	}
	private WeatherDto transformDto(WeatherStackDto weatherstackData) {
		WeatherDto wdto = new WeatherDto();
		wdto.setLocation(weatherstackData.getLocation().getName());
		wdto.setRelative_humidity(weatherstackData.getCurrent().getHumidity());
		wdto.setTemp_celsius(weatherstackData.getCurrent().getTemperature());
		wdto.setTimestamp(weatherstackData.getLocation().getLocaltime());
		wdto.setWeather_description(weatherstackData.getCurrent().getWeather_descriptions().get(0));
		wdto.setWind_direction(weatherstackData.getCurrent().getWind_dir());
		wdto.setWind_speed_m_per_s(weatherstackData.getCurrent().getWind_speed());
		return wdto;
	}
}
