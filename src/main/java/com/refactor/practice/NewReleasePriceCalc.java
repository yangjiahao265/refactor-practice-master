package com.refactor.practice;

/**
 * NEW_RELEASE 价格计算规则
 * @author 杨佳豪
 * @date 2024-09-12
 */
public class NewReleasePriceCalc implements MovieRentalPriceCalc {

	@Override
	public Double calcMoviePrice(Integer rentalDays) {
		return rentalDays * 3.0;
	}

	@Override
	public Boolean supportMovie(Integer movieType) {
		return MovieType.NEW_RELEASE.getPriceCode().equals(movieType);
	}

	@Override
	public Integer calcPoints(Integer rentalDays) {
		if (rentalDays > 1) {
			return 2;
		}
		return 1;
	}

}
