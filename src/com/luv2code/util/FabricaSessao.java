package com.luv2code.util;

import com.luv2code.hibernate.demo.entity.Dispositivo;
import com.luv2code.hibernate.demo.entity.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FabricaSessao {

    public Session getSession() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Dispositivo.class)
                .addAnnotatedClass(Usuario.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        return session;
    }
}
