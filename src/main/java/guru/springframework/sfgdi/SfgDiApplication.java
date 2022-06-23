package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		System.out.println("---- Primary Bean");
		MyController myController = (MyController) ctx.getBean("myController");
//		MyController myController = ctx.getBean(MyController.class);
		System.out.println(myController.sayHello());

		System.out.println("----- Property");
		PropertyInjectedController propertyInjectedController = ctx.getBean(PropertyInjectedController.class);
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("----- Setter");
		SetterInjectedController setterInjectedController = ctx.getBean(SetterInjectedController.class);
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("----- Constructor");
		ConstructorInjectedController constructorInjectedController = ctx.getBean(ConstructorInjectedController.class);
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("----- Profiles");
		I18nController i18nController = ctx.getBean(I18nController.class);
		System.out.println(i18nController.sayHello());
	}

}
