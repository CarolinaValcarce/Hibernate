package PAC;

import PAC.Alumno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class Main {
    public static void main (String[] args){
        System.out.println ("Programa iniciando");
        Configuration cfg = new Configuration ().configure();
        SessionFactory sessionFactory= cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session= sessionFactory.openSession();
        System.out.println("Configuración realizada");
        Transaction tx= session.beginTransaction();

        Modulo a= new Modulo();
        a.setNombre("Programación B");
        a.setCodigo("M03B");
        session.save(a);

        Modulo b= new Modulo();
        b.setNombre("Acceso a Datos");
        b.setCodigo("M06");
        session.save(b);

        Modulo c= new Modulo();
        c.setNombre("Desarrollo de aplicaciones móviles");
        c.setCodigo("M08");
        session.save(c);

        Modulo d= new Modulo();
        d.setNombre("Servicios y procesos");
        d.setCodigo("M09");
        session.save(d);

        Alumno e= new Alumno();
        e.setNombre("Juan");
        e.setNacionalidad("Espaniola");
        e.setEdad(26);
        e.setSexo("Hombre");
        e.addModulo(a);
        e.addModulo(b);
        e.addModulo(c);
        e.addModulo(d);
        session.save(e);

        Alumno f= new Alumno();
        f.setNombre("Pedro");
        f.setNacionalidad("Andorrana");
        f.setEdad(21);
        f.setSexo("Hombre");
        f.addModulo(a);
        f.addModulo(b);
        f.addModulo(d);
        session.save(f);

        Alumno g= new Alumno();
        g.setNombre("Marta");
        g.setNacionalidad("Espaniola");
        g.setEdad(19);
        g.setSexo("Mujer");
        g.addModulo(c);
        g.addModulo(d);
        session.save(g);

        Alumno h= new Alumno();
        h.setNombre("Carla");
        h.setNacionalidad("Francesa");
        h.setEdad(35);
        h.setSexo("Mujer");
        h.addModulo(b);
        h.addModulo(c);
        h.addModulo(d);
        session.save(h);

        Profesor m=new Profesor();
        m.setNombre("Alvaro");
        m.setSexo("Hombre");
        session.save(m);
        tx.commit();

        tx= session.beginTransaction();
        Query query=session.createQuery("FROM PAC.Modulo");
        List list= query.list();
        for (int  i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
        Query query2=session.createQuery("FROM PAC.Alumno");
        List list2= query2.list();
        for (int  i=0;i<list2.size();i++){
            System.out.println(list2.get(i).toString());
        }
        Query query3=session.createQuery("FROM PAC.Profesor");
        List list3= query3.list();
        for (int  i=0;i<list3.size();i++){
            System.out.println(list3.get(i).toString());
        }

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}



