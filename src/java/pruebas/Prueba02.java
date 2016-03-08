
package pruebas;

import java.util.Iterator;
import model.Departamentos;
import model.Distritos;
import model.HibernateUtil;
import model.Provincias;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

public class Prueba02 {
    
    public static void main(String[] args) {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        String s = "from Departamentos";
        Query query = session.createQuery(s);
        Iterator it = query.iterate();
        
        while (it.hasNext()) {
            Departamentos dep = (Departamentos)it.next();
            System.out.println("Departamento " + dep.getDepartamento() + ":");
            
            /*String t = "from Provincias";
            Query query2 = session.createQuery(t);*/
            Iterator proIt = dep.getProvinciases().iterator();
            System.out.println("\t\tProvincias: ");
            
            while (proIt.hasNext()) {
                Provincias prov = (Provincias)proIt.next();
                System.out.println("\t\t\t" + prov.getProvincia());
                
                Iterator disIt = prov.getDistritoses().iterator();
                System.out.println("\t\t\t\tDistrintos: ");
                while (disIt.hasNext()) {
                    Distritos dist = (Distritos)disIt.next();
                    System.out.println("\t\t\t\t" + dist.getDistrito());
                }
                
            }
        }
     
        session.close();
        
    }
    
}
