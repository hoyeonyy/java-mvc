package reflection;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

class Junit4TestRunner {

	@Test
	void run() throws Exception {
		Class<Junit4Test> clazz = Junit4Test.class;
		Method[] methods = clazz.getDeclaredMethods();
		Object instance = clazz.getDeclaredConstructor().newInstance();

		for (Method method : methods) {
			if (method.isAnnotationPresent(MyTest.class)) {
				method.invoke(instance);
			}
		}
	}
}
