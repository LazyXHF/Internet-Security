/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package cn.xu.encryption.controller;

import java.util.UUID;

import cn.xu.encryption.base.BaseApiService;
import cn.xu.encryption.base.BaseRedisService;
import cn.xu.encryption.base.ResponseBase;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 使用令牌方式防止抓包篡改数据
 */
@RestController
public class PayController extends BaseApiService {
	@Autowired
	private BaseRedisService baseRedisService;
	private static long timeToken = 15 * 60l;

	@RequestMapping("/pay")
	public ResponseBase pay(String token) {
		// 获取提交参数 数据库保存.,
		if (StringUtils.isEmpty(token)) {
			return setResultError("token 不能为空！");
		}
		String reuslt = (String) baseRedisService.getString(token);
		if (StringUtils.isEmpty(reuslt)) {
			return setResultError("参数不能空!");
		}
		System.out.println("获取提交的参数reuslt：" + reuslt);
		return setResultSuccess("获取提交的参数reuslt：" + reuslt);
	}

	/**
	 *服务端调用
	 * 用户购买商品,传递商铺id给后台,后台查询商品成产对应的token给前端支付
	 * @param userId
	 * @param money
	 * @return
	 */
	@RequestMapping("/getPayToken")
	public String pay(Long userId, Long money) {
		String payToken = UUID.randomUUID().toString();
		baseRedisService.setString(payToken, userId + "-" + money, timeToken);
		return payToken;
	}

}
