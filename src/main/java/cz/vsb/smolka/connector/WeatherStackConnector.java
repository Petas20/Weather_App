package cz.vsb.smolka.connector;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import cz.vsb.smolka.City;
import cz.vsb.smolka.dto.WeatherStackDto;
import cz.vsb.smolka.service.WeatherService;

public class WeatherStackConnector {
	//http://api.weatherstack.com/current?access_key=a68bd378600ea91da00f10c54cfd64c9&query=New%20York
	
	private static String baseUrl="http://api.weatherstack.com/";
	private static String params="current?access_key=";
	private static String APIkey="a68bd378600ea91da00f10c54cfd64c9";
	private static String url=baseUrl+params+APIkey+"&query=";
	
	public WeatherStackDto getWeatherForCity(City cityEnum)  {
		RestTemplate template=new RestTemplate();
		URI uri=null;
		try {
		uri=new URI(url+cityEnum.toString());
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<WeatherStackDto> response=template.getForEntity(uri, WeatherStackDto.class);
		return response.getBody();
	}
}
