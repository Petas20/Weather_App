package cz.vsb.smolka.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.vsb.smolka.City;
import cz.vsb.smolka.connector.WeatherStackConnector;
import cz.vsb.smolka.dto.Location;
import cz.vsb.smolka.dto.WeatherDto;
import cz.vsb.smolka.service.WeatherService;
@RestController
public class WeatherController {
	WeatherService service;
	@RequestMapping("weather")
	public Collection<WeatherDto> getWeather() {
		ArrayList<WeatherDto> wdtos=new ArrayList<WeatherDto>();
		service=new WeatherService();
		for (City city : City.values()) {
			WeatherDto weatherDto=service.getWeatherForCity(city);
			wdtos.add(weatherDto);
		}
		return wdtos;
		}
	
	@RequestMapping("weather/{city}")
	@CrossOrigin
	public WeatherDto getWeatherForCity(@PathVariable String city) {
		City cityEnum= City.valueOf(city.toUpperCase());
		service=new WeatherService();
		return service.getWeatherForCity(cityEnum);
	}
	@RequestMapping("/weather/Psojedy")
	public String getWeatherForCity() {
		return "<h1>Psojedy neexistujou</h1> <img src='http://https://b2e3a07bca.cbaul-cdnwnd.com/122f3ec818ba95bef912d205e38eabaf/200000543-523d15336e/pl%C3%A1n.jpg'/>";
	}
	@RequestMapping("/")
	public String home() {
		return "<h1>Weather in YOUR favorite cities</h1>";
	}
}
