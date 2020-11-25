package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Dispositivo;
import com.luv2code.hibernate.demo.entity.Usuario;
import com.luv2code.util.FabricaSessao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForMaryDemo {

	public static void main(String[] args) {

		Session s = new FabricaSessao().getSession();

		try {
			s.getTransaction().begin();

			Dispositivo d1 = new Dispositivo();
			d1.setNumero("65981522040");
			d1.setImei("123456789123456");
			d1.setStatus("1");
			d1.setTipo("1");

			s.save(d1);

			Usuario u1 = new Usuario();
			u1.setNome("Onias da Rocha Filho");
			u1.setCpf("03037334118");
			u1.setEmail("onias.filho@gmail.com");

			d1.addUsuario(u1);

			s.save(u1);

			s.getTransaction().commit();

			System.out.println("Feito :)");
		}
		finally {

		}
	}


}





