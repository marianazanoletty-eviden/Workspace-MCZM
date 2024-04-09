package es.escuela.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoDocentes {

	public static void main(String[] args) {
	/*
		//Creamos los objetos de tipo Docente
		Docentes profesor1 = new ProfesorIngles();
		Docentes profesor2 = new ProfesorMatematicas();
		//Usamos los objetos creados
		System.out.println(profesor1.getAsignatura());
		System.out.println(profesor2.getAsignatura());

*/
		
		//Archivo XML
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Docentes Juseph = contexto.getBean("profeIngles", Docentes.class);
		
		System.out.println("Juseph: " + Juseph.getAsignatura());
		
		Docentes Jaime = contexto.getBean("profeMates", Docentes.class);
		
		System.out.println("Jaime: " + Jaime.getAsignatura());
		
		//cerramos el archivo .xml
		
		contexto.close();
	}

}
