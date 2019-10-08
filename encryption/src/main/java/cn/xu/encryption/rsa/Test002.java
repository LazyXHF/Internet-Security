/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package cn.xu.encryption.rsa;

import javax.crypto.Cipher;


public class Test002 {

	public static void main(String[] args) {

		// 1. 生成(公钥和私钥)密钥对
		RSAUtil.generateKey();
		System.out.println("公钥:" + RSAUtil.publicKey);
		System.out.println("私钥:" + RSAUtil.privateKey);
		System.out.println("----------公钥加密私钥解密-------------");
		// 使用 公钥加密,私钥解密
		String textsr = "yushengjun";
		String encryptByPublic = RSAUtil.encryptByPublicKey(textsr, RSAUtil.publicKey, Cipher.ENCRYPT_MODE);
		System.out.println("公钥加密:" + encryptByPublic);
		String text = RSAUtil.encryptByprivateKey(encryptByPublic, RSAUtil.privateKey, Cipher.DECRYPT_MODE);
		System.out.print("私钥解密:" + text);
	}

}
