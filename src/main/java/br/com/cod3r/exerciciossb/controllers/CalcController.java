package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.model.Calc;

@RestController
public class CalcController {

	@GetMapping(path = "/sum/{a}/{b}")
	public double sum(@PathVariable double a, @PathVariable double b) {
		Calc calc = new Calc(a, b);
		double result = calc.sum(a, b);
		return result;
	}
	
	@GetMapping(path = "/subtract")
	public double subtract(@RequestParam(value = "a") double a, @RequestParam(value = "b") double b) {
		return Calc.subtract(a, b);
	}
}
