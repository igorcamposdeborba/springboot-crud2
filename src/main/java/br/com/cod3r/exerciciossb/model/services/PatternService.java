package br.com.cod3r.exerciciossb.model.services;

public class PatternService {

	public static Double validateTypeDouble(Double number) {
		Double numberFormatted = number;
		
		if (number.toString().contains(",")) {
			String convertedToString = convertDoubleToString(number);
			convertedToString.replace(",", ".");
			
			Double convertedToDouble = convertStringToDouble(convertedToString);
			
			numberFormatted = convertedToDouble;
		}
		return numberFormatted;
		
	}
	
	public static String convertDoubleToString(Double number) {
		return Double.toString(number);
	}
	public static Double convertStringToDouble(String string) {
		return Double.parseDouble(string);
	}
}
