/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package cn.xu.encryption.rsa;

import javax.crypto.Cipher;

public class Test003 {

	public static void main(String[] args) {

		// 1. 生成(公钥和私钥)密钥对
		RSAUtil.generateKey();
		System.out.println("公钥:" + RSAUtil.publicKey);
		System.out.println("私钥:" + RSAUtil.privateKey);
		System.out.println("----------私加密公钥解密-------------");
		// 使用 私加密,公钥解密
		String textsr = "yushengjun";
		String encryptByprivate = RSAUtil.encryptByprivateKey(textsr, RSAUtil.privateKey, Cipher.ENCRYPT_MODE);
		System.out.println("私钥加密后:" + encryptByprivate);
		String encryptByPublic = RSAUtil.encryptByPublicKey(encryptByprivate, RSAUtil.publicKey, Cipher.DECRYPT_MODE);
		System.out.println("公钥解密后:" + encryptByPublic);
	}

}
