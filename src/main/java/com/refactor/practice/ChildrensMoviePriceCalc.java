package com.refactor.practice;

/**
 * CHILDRENS 价格计算规则
 * @author 杨佳豪
 * @date 2024-09-12
 */
public class ChildrensMoviePriceCalc implements MovieRentalPriceCalc {

	@Override
	public Double calcMoviePrice(Integer rentalDays) {
		double finalPrice = 1.5;
		if (rentalDays > 3) {
			finalPrice += (rentalDays - 3) * 1.5;
		}
		return finalPrice;
	}

	@Override
	public Boolean supportMovie(Integer movieType) {
		return MovieType.CHILDRENS.getPriceCode().equals(movieType);
	}

}
