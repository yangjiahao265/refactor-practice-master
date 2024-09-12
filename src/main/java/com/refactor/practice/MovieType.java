package com.refactor.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 电影类型 个人喜欢采用枚举维护
 * @author 杨佳豪
 * @date 2024-09-12
 */
public enum MovieType {

	REGULAR(0),
	NEW_RELEASE(1),
	CHILDRENS(2);

	private final Integer priceCode;

	MovieType(Integer priceCode) {
		this.priceCode = priceCode;
	}

	public Integer getPriceCode() {
		return priceCode;
	}

	/**
	 * 手动注册所有实现，实际情况下可以采用ioc容器来管理实现
	 * 使用 MovieRentalPriceCalc.supportMovie 方法来规避手动绑定电影类型和规则实现关系
	 */
	public static final List<MovieRentalPriceCalc> RENTAL_PRICE_CALCS =  new ArrayList<>();

	static {
		RENTAL_PRICE_CALCS.add(new RegularMoviePriceCalc());
		RENTAL_PRICE_CALCS.add(new NewReleasePriceCalc());
		RENTAL_PRICE_CALCS.add(new ChildrensMoviePriceCalc());
	}

}
