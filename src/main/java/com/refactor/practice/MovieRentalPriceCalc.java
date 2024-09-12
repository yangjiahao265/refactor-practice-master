package com.refactor.practice;

/**
 * 电影租借价格 策略接口
 * @author 杨佳豪
 * @date 2024-09-12
 */
public interface MovieRentalPriceCalc {

	/**
	 * 计算不同电影租借价格
	 * @param rentalDays 租借时间
	 * @return 价格
	 */
	Double calcMoviePrice(Integer rentalDays);

	/**
	 * 当前计算实现是否支持该电影类型
	 * @param movieType 电影类型
	 * @return 是否支持
	 */
	Boolean supportMovie(Integer movieType);

	/**
	 * 计算不同电影的积分规则
	 * @param rentalDays 租借时间
	 * @return 积分点数 默认为1
	 */
	default Integer calcPoints(Integer rentalDays) {
		return 1;
	}

}
