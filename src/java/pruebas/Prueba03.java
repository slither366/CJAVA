package pruebas;

import java.util.Iterator;
import model.Departamentos;
import model.Distritos;
import model.HibernateUtil;
import model.Provincias;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

public class Prueba03 {

    public static void main(String[] args) {

        int canProv, canDist;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        String s = "from Departamentos";

        Query query = session.createQuery(s);
        Iterator it = query.iterate();

        while (it.hasNext()) {
            Departamentos dep = (Departamentos) it.next();
            System.out.println("Departamentos: " + dep.getDepartamento());

            Iterator itProv = dep.getProvinciases().iterator();
            canProv = 0;
            canDist = 0;

            while (itProv.hasNext()) {
                Provincias prov = (Provincias)itProv.next();
                canProv++;
                
                Iterator itDist = prov.getDistritoses().iterator();
                while (itDist.hasNext()) {
                    Distritos dis = (Distritos)itDist.next();
                    canDist++;
                }
            }
            
            System.out.println("\tProvincias: " + canProv);
            System.out.println("\tDistritos: " + canDist);
        }

        session.close();
    }

}
