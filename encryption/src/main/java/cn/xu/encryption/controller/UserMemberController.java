/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package cn.xu.encryption.controller;

import javax.crypto.Cipher;

import cn.xu.encryption.rsa.RSAUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserMemberController {
	@Value("${private_key}")
	private String privateKey;

	// 使用公钥加密 私钥解密
	@RequestMapping("/getMember")
	public String getMember(String userName) {
		String decUserName;
		try {
			decUserName = RSAUtil.encryptByprivateKey(userName, privateKey, Cipher.DECRYPT_MODE);
		} catch (Exception e) {
			return "解密错误!";
		}
		if (StringUtils.isEmpty(decUserName)) {
			return "解密失败!";
		}

		System.out.println("解密成功 decUserName:" + decUserName);
		return "解密成功!";
	}

}
