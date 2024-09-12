package com.refactor.practice;

/**
 * REGULAR 价格计算规则
 * @author 杨佳豪
 * @date 2024-09-12
 */
public class RegularMoviePriceCalc implements MovieRentalPriceCalc {

	@Override
	public Double calcMoviePrice(Integer rentalDays) {
		double finalPrice = 2;
		if (rentalDays > 2) {
			finalPrice += (rentalDays - 2) * 1.5;
		}
		return finalPrice;
	}

	@Override
	public Boolean supportMovie(Integer movieType) {
		return MovieType.REGULAR.getPriceCode().equals(movieType);
	}

}
