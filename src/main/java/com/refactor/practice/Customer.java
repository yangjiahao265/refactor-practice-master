package com.refactor.practice;

import java.util.Enumeration;
import java.util.Optional;
import java.util.Vector;

import static com.refactor.practice.MovieType.RENTAL_PRICE_CALCS;

public class Customer {
	private String _name;
	private Vector _rentals;

	public Customer(String _name, Vector _rentals) {
		this._name = _name;
		this._rentals = _rentals;
	}

	public String getName() {
		return _name;
	}

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			double thisAmount = 0D;
			Rental each = (Rental) rentals.nextElement();

			//determine amounts for each line
			/*
			switch (each.getMovie().getPriceCode()) {
				case Movie.REGULAR:
					thisAmount += 2;
					if (each.getDayRented() > 2) {
						thisAmount += (each.getDayRented() - 2) * 1.5;
					}
					break;
				case Movie.NEW_RELEASE:
					thisAmount += each.getDayRented() * 3;
					break;
				case Movie.CHILDRENS:
					thisAmount += 1.5;
					if (each.getDayRented() > 3) {
						thisAmount += (each.getDayRented() - 3) * 1.5;
					}
					break;
			}

			//add frequent renter points
			frequentRenterPoints++;
			//add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
					each.getDayRented() > 1) {
				frequentRenterPoints++;
			}
			 */

			// 策略模式重构
			Optional<MovieRentalPriceCalc> optional = RENTAL_PRICE_CALCS.stream()
				.filter(movieRentalPriceCalc ->
					movieRentalPriceCalc.supportMovie(each.getMovie().getPriceCode())).findFirst();

			if (optional.isPresent()) {
				// 计算价格
				thisAmount = optional.get().calcMoviePrice(each.getDayRented());
				// 计算积分
				Integer calcPoints = optional.get().calcPoints(each.getDayRented());
				frequentRenterPoints = frequentRenterPoints + calcPoints;
			}

			//show figures for this rental
			result += "\t" + each.getMovie().getTitle() +
					"\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned" + String.valueOf(frequentRenterPoints) +
				" frequent renter points";
		return result;
	}
}
