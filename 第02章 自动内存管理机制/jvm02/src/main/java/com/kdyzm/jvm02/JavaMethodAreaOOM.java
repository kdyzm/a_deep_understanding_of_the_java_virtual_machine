package com.kdyzm.jvm02;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M <br/>
 * 该设置只针对1.6有效，对1.7+无效，因为常量区在1.7移出了永久代（方法区）<br/>
 * 借助CGLib生成动态类（增强类）使方法区出现out of memory异常<br/>
 * 
 * @author kdyzm
 *
 */
public class JavaMethodAreaOOM {
	static class OOMObject {

	}

	public static void main(String[] args) {
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {

				@Override
				public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
					return proxy.invokeSuper(obj, args);
				}

			});
			enhancer.create();
		}
	}
}
